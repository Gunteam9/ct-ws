package v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class BadUriException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4221006469682830985L;

	public BadUriException() {
		super("Error during the creation of the URI ressource location");
		
	}

	public BadUriException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BadUriException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BadUriException(String message) {
		super(message);
		
	}

	public BadUriException(Throwable cause) {
		super(cause);
		
	}

	
}
