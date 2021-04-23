package v1.facade;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import v1.exceptions.UserAlreadyExistException;
import v1.model.User;

@Component("UserFacade")
public class UserFacadeImpl implements UserFacade {

	private final Map<String, User> users = new HashMap<String, User>();
	
	@Override
	public User register(String username, String password) throws UserAlreadyExistException {
		if (users.containsKey(username))
			throw new UserAlreadyExistException();
		
		User user = new User(username, password);
		users.put(username, user);
		
		return user;
	}

}
