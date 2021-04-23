package v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ChildNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7136469890258816092L;

	public ChildNotFoundException() {
		super("Child not found");
		
	}

	public ChildNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ChildNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ChildNotFoundException(String message) {
		super(message);
		
	}

	public ChildNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
	
}
