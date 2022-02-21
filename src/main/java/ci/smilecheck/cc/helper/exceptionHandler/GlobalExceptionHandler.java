package ci.smilecheck.cc.helper.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
//import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ci.smilecheck.cc.helper.contrat.ResponseBase;
import ci.smilecheck.cc.helper.error.ErrorMessage;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	
	
	
	@ExceptionHandler(BusinessEntityNotFound.class)
	public ResponseEntity<Object>  businessEntityNotFound(BusinessEntityNotFound ex,Exception exp, WebRequest req){
		ResponseBase responseBase=new ResponseBase();
		responseBase.setTechnicalError(ex.getMessage());
		responseBase.setHasError(true);
		responseBase.setErrorMessage(exp.getMessage());
		logger.error(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<Object>(responseBase,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BusinessBadRequest.class)
	public ResponseEntity<Object> businessEntityBadRequest(BusinessBadRequest ex, WebRequest req){
		ResponseBase responseBase=new ResponseBase();
		responseBase.setTechnicalError(ex.getMessage());
		responseBase.setHasError(true);
		responseBase.setErrorMessage(ex.getMessage());
		logger.error(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<Object>(responseBase,HttpStatus.BAD_REQUEST);

	}
	
	
	
	/**
	 * Customize the response for MethodArgumentNotValidException.
	 * <p>This method delegates to {@link #handleExceptionInternal}.
	 * @param ex the exception
	 * @param headers the headers to be written to the response
	 * @param status the selected response status
	 * @param request the current request
	 * @return a {@code ResponseEntity} instance
	 */
	@Override  
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request)   
	{  
		 
		ResponseBase responseBase=new ResponseBase();
		responseBase.setTechnicalError(ex.getMessage());
		responseBase.setHasError(true);
		responseBase.setErrorMessage(ex.getMessage());
		//return responseBase;
		ex.printStackTrace();
		return new ResponseEntity<Object>(responseBase, HttpStatus.BAD_REQUEST);
	}  
	
	
	
	
	
	/* use with validation annotation
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}*/
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest req){
		ResponseBase responseBase=new ResponseBase();
		responseBase.setTechnicalError(ex.getMessage());
		responseBase.setHasError(true);
		responseBase.setErrorMessage(ErrorMessage.ERROR_SERVEUR_500);
		logger.error(ex.getMessage());
		ex.printStackTrace();
		return new ResponseEntity<Object>(responseBase,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
