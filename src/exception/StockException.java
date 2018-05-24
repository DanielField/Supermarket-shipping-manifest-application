/**
 * 
 */
package exception;

/**
 * Occurs when there is an issue regarding the Stock class.
 * 
 * @author Daniel Field
 *
 */
public class StockException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construct a stock exception
	 */
	public StockException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public StockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public StockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public StockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
