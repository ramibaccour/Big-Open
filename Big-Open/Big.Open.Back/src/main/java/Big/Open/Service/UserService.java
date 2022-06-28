package big.open.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.User;
import big.open.payload.request.UserRequest;
import big.open.payload.response.UserResponse;
import big.open.payload.response.UserResponseFindById;
import big.open.payload.response.UserResponseSave;
import big.open.payload.response.error.UserResponseError;
import big.open.repository.UserRepository;
import big.open.security.jwt.JwtUtils;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class UserService
{
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	UserRepository userRepository;
	public UserResponseFindById findById(Integer id)
	{
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent())
		{
			UserResponse userResponse = ObjectMapperUtility.map(user.get(),UserResponse.class);
			return new UserResponseFindById(userResponse);
		}
		return new UserResponseFindById("Non trouvé");
	}
	public UserResponseSave save(UserRequest userRequest)
	{
		UserResponseError userResponseError = checkUserResponseError(userRequest);
		if(userResponseError.isHave_error())
		{
			return new UserResponseSave(userResponseError);
		}
		else
		{
			try
			{
				User user = userRepository.save(ObjectMapperUtility.map(userRequest, User.class));
				return  new UserResponseSave(ObjectMapperUtility.map(user, UserResponse.class));
			}
			catch(Exception e)
			{
				userResponseError.setHave_error(true);
				return  new UserResponseSave("Erreur d'enregistrement");
			}
		}
	}
	public String delete(Integer id)
	{
		try
		{
			var user = userRepository.findById(id);
			if(user.get().getIsDeleted() == 0)
				user.get().setIsDeleted(1);
			else
				user.get().setIsDeleted(0);
			userRepository.save(user.get());
			return "";
		}
		catch(Exception e)
		{
			return "Erreur de suppression";
		}
	}
	private UserResponseError checkUserResponseError (UserRequest userRequest)
	{
		UserResponseError userResponseError = new UserResponseError();
		userResponseError.setHave_error(false);
		if(Utility.isEmpty(userRequest.getId().toString()) )
		{
			userRequest.setId(-1);
		}
		//if(Utility.isEmpty(userRequest.get()) )
		//{
				//userResponseError.setHave_error(true);
				//userResponseError.set("Le nom d'utilisateur est obligatoire");
		//}
		return userResponseError;
	}
}
