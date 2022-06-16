package Big.Open.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Big.Open.Entity.User;
import Big.Open.Repository.UserRepository;
import Big.Open.Utility.ObjectMapperUtility;


@Service
public class UserService 
{
	@Autowired
	UserRepository userRepository;
//	public UserResponseFindById findById(Integer id)
//	{
//		Optional<User> user = userRepository.findById(id);
//		if(user.isPresent())
//		{
//			UserResponse userResponse = ObjectMapperUtility.map(user.get(),UserResponse.class);
//			
//			return new UserResponseFindById(userResponse);
//		}
//		return new UserResponseFindById("User not found");
//	}
}
