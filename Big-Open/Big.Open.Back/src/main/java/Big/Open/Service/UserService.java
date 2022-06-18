package big.open.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import big.open.entity.User;
import big.open.payload.request.UserRequest;
import big.open.payload.response.UserResponse;
import big.open.payload.response.UserResponseFindById;
import big.open.payload.response.UserResponseSave;
import big.open.payload.response.erreor.UserResponseError;
import big.open.repository.UserRepository;
import big.open.utility.ObjectMapperUtility;
import big.open.utility.Utility;
@Service
public class UserService 
{
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
	public UserResponseSave save(UserRequest userRequestSave)
	{
		
		UserResponseError userResponseError = checkUserResponseError(userRequestSave);
		
		if(!userResponseError.isHaveError())
		{		
			return new UserResponseSave(userResponseError);
		}
		else
		{
			try
			{
				var user = userRepository.save(ObjectMapperUtility.map(userRequestSave, User.class));
				return  new UserResponseSave(ObjectMapperUtility.map(user, UserResponse.class));
			}
			catch(Exception e)
			{
				userResponseError.setHaveError(true);
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
	private UserResponseError checkUserResponseError (UserRequest userRequestSave)
	{	
		UserResponseError userResponseError = new UserResponseError();
		userResponseError.setHaveError(false);
		if(Utility.isEmpty(userRequestSave.getUsername()) )
		{
			userResponseError.setHaveError(true);
			userResponseError.setUsername("Le nom d'utilisateur est obligatoire");
		}
		
		return userResponseError;
	}
}
