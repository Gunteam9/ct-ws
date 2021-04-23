package v1.facade;

import v1.exceptions.UserAlreadyExistException;
import v1.model.User;

public interface UserFacade {
	public User register(String username, String password) throws UserAlreadyExistException;
}
