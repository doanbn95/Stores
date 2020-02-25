package haui.doan.stores.exception;

/**
 * Interface for system;s exceptions
 *
 * @param <T> which extends Exception
 */
public interface IExceptionHandler<T extends Exception> {

	/**
	 * Handle exception behavior
	 *
	 * @param exception which extends Exception
	 * @return error response {@link ErrorResponse}
	 */
	ErrorResponse handle(T exception);

}
