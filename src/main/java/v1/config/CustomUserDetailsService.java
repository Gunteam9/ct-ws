package v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import v1.facade.NurseryFacade;
import v1.facade.ParentFacade;
import v1.model.Admin;
import v1.model.Parent;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	private static final String[] ROLES_ADMIN = {"USER", "ADMIN"};
	private static final String[] ROLES_USER = {"USER"};
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NurseryFacade nurseryFacade;
	
	@Autowired
	private ParentFacade parentFacade;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = nurseryFacade.getAdmin(username);
		Parent user = parentFacade.getParent(username);
		
		System.out.println(admin);

		if (user == null && admin == null)
			throw new UsernameNotFoundException("User " + username + " not found");
		String[] roles = admin != null ? ROLES_ADMIN : ROLES_USER;
		
		UserDetails userDetails = null;
		
		if (admin != null) {
			userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(username)
					.password(passwordEncoder.encode(admin.getPassword()))
					.roles(roles)
					.build();
		}
		else if (user != null) {
			userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(username)
					.password(passwordEncoder.encode(user.getPassword()))
					.roles(roles)
					.build();
		}
		
		return userDetails;
	}
}
