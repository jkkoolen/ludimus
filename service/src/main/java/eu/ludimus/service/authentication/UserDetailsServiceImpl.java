package eu.ludimus.service.authentication;

import eu.ludimus.domain.entity.User;
import eu.ludimus.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0)	throws UsernameNotFoundException {
		User user = userRepository.findByName(arg0);
		if (user == null)
		      throw new UsernameNotFoundException(String.format("user with name %s not found", arg0));
		
		return new LudimusUserDetails(mapeTo(user), user);
	}
	
	private org.springframework.security.core.userdetails.User mapeTo(User user) {
		return new org.springframework.security.core.userdetails.User(user.getName()
				,user.getPassword()
				,user.isActive()
				,user.isActive()
				,user.isActive()
				,user.isActive()
				,Arrays.asList(new SimpleGrantedAuthority[]{new SimpleGrantedAuthority(user.getRole().name())}));
	}

}
