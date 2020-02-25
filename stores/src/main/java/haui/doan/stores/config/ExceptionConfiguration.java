package haui.doan.stores.config;

import haui.doan.stores.exception.BindExceptionHandler;
import haui.doan.stores.exception.IExceptionHandler;
import haui.doan.stores.exception.ServiceException;
import haui.doan.stores.exception.ServiceExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

/**
 * System's Exceptions configuration
 */
@Configuration
public class ExceptionConfiguration {

	/**
	 * Init ServiceExceptionHandler bean
	 *
	 * @return ServiceExceptionHandler bean
	 */
	@Bean
	public IExceptionHandler<ServiceException> serviceExceptionHandler() {
		return new ServiceExceptionHandler();
	}

	/**
	 * Init BindExceptionHandler bean
	 *
	 * @return BindExceptionHandler bean
	 */
	@Bean
	public IExceptionHandler<BindException> bindExceptionHandler() {
		return new BindExceptionHandler();
	}
}
