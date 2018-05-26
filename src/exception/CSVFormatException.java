/**
 * 
 */
package exception;

/**
 * Occurs when there is an issue with formatting in a comma separated values (CSV) file.
 * 
 * @author Daniel Field
 * @author Allen Basic
 */
public class CSVFormatException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Construct the exception object.
	 */
	public CSVFormatException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param message
	 */
	public CSVFormatException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param cause
	 */
	public CSVFormatException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construct the exception object.
	 * 
	 * @param message
	 * @param cause
	 */
	public CSVFormatException(String message, Throwable cause) {
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
	public CSVFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
