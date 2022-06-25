package big.open.service;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import big.open.entity.User;
import big.open.payload.request.UserRequest;
import big.open.payload.response.UserResponse;
import big.open.payload.response.UserResponseFindById;
import big.open.payload.response.UserResponseSave;
import big.open.payload.response.UserResponseSignin;
import big.open.payload.response.erreor.UserResponseError;
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
		return new UserResponseFindById("User not found");
	}
	public UserResponseSignin signin(UserRequest userRequestSignin) 
	{
		return getUserResponseSignin(userRequestSignin.getUsername(), userRequestSignin.getPassword());				
		
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
				userRequest.setPassword(encoder.encode(userRequest.getPassword()));
				User user = ObjectMapperUtility.map(userRequest, User.class);
				userRepository.save(user);
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
		if(Utility.isEmpty(userRequest.getUsername()) )
		{
			userResponseError.setHave_error(true);
			userResponseError.setUsername("Le nom d'utilisateur est obligatoire");
		}
		return userResponseError;
	}
	private UserResponseSignin getUserResponseSignin (String login, String password)
	{
		var user = userRepository.findByUsernameAndIsDeleted(login, 0);
		if (user.isPresent())
		{
			var verifPassword = encoder.matches( password, user.get().getPassword()) ;
			if(verifPassword)
			{
				var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login, password);
				Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
				
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(user.get().getUsername());										
				ModelMapper mapper = new ModelMapper();
				UserResponse userResponse = mapper.map(user.get(), UserResponse.class);
				UserResponseSignin userResponseSignin = new UserResponseSignin(userResponse, jwt, null);
				return userResponseSignin;
			}
		}
		UserResponseError userResponseError = new UserResponseError("les données d'authentification sont incorrectes");
		userResponseError.setHave_error(true);
		return new UserResponseSignin(userResponseError);
	}
}