package haui.doan.stores.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Error Response data when exception handling
 */
@Data
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = -5214318729027027493L;

	private static transient ResourceBundle bundle = null;

	private static transient String ERROR_MSG_HTTP_STATUS_REQUIRED = null;

	@JsonIgnore
	private HttpStatus httpStatus;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;


	private String message;

	@JsonProperty(value = "error_codes")
	private List<String> errorCodes;

	@JsonProperty(value = "validation_errors")
	private Map<String, Object> validationErrors = new HashMap<>();


	private ErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	private ErrorResponse(HttpStatus httpStatus, String message, List<String> errorCodes, Map<String, Object> validationErrors) {
		this(httpStatus, message, errorCodes);
		this.validationErrors = validationErrors;
	}

	private ErrorResponse(HttpStatus httpStatus, String message, List<String> errorCodes) {
		this();
		this.httpStatus = httpStatus;
		this.message = message;
		this.errorCodes = errorCodes;
	}

	public static ErrorResponse of(HttpStatus httpStatus, String message, List<String> errorCodes) {
		if (httpStatus == null) {
			throw new IllegalArgumentException(ERROR_MSG_HTTP_STATUS_REQUIRED);
		}
		String errMsg = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);
		List<String> list = errorCodes == null ? Collections.emptyList() : errorCodes;
		return new ErrorResponse(httpStatus, errMsg, list);
	}

	public static ErrorResponse of(HttpStatus httpStatus, String message, List<String> errorCodes, Map<String, Object> validationErrors) {
		if (httpStatus == null) {
			throw new IllegalArgumentException(ERROR_MSG_HTTP_STATUS_REQUIRED);
		}
		String errMsg = StringUtils.defaultIfBlank(message, StringUtils.EMPTY);

		return new ErrorResponse(httpStatus, errMsg, errorCodes, validationErrors);
	}

	@Data
	@AllArgsConstructor
	public static class ItemError {
		@JsonProperty(value = "reject_value")
		private Object rejectValue;

		@JsonProperty(value = "reason")
		private String reason;
	}
}
