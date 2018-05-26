/**
 * 
 */
package exception;

/**
 * Occurs when there is an error regarding trucks and their cargo.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class DeliveryException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construct the exception object.
	 */
	public DeliveryException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param message
	 */
	public DeliveryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param cause
	 */
	public DeliveryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param message
	 * @param cause
	 */
	public DeliveryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DeliveryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
