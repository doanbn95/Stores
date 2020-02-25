package haui.doan.stores.exception;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Handle exceptions across the whole application
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    @Qualifier("serviceExceptionHandler")
    private IExceptionHandler<ServiceException> serviceExceptionHandler;

    @Autowired
    @Qualifier("bindExceptionHandler")
    private IExceptionHandler<BindException> bindExceptionHandler;

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        ErrorResponse errorResponse = serviceExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }


    @ExceptionHandler({
            BindException.class
    })
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        ErrorResponse errorResponse = bindExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}
