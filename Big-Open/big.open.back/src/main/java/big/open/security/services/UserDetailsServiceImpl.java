package big.open.security.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import big.open.entity.User;
import big.open.repository.UserRepository;
@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{
	@Autowired
	UserRepository userRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<User> user = userRepository.findByUsernameAndIsDeleted(username,0);
		if(user.isPresent())
			return UserDetailsImpl.build(user.get());
		else
			return UserDetailsImpl.build(new User());
	}
}