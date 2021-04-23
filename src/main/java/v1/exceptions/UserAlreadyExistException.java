package v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465649580996166445L;

	public UserAlreadyExistException() {
		super("User already exist");
		
	}

	public UserAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UserAlreadyExistException(String message) {
		super(message);
		
	}

	public UserAlreadyExistException(Throwable cause) {
		super(cause);
		
	}

	
	
}
