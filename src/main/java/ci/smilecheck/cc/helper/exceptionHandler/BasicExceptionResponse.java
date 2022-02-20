package ci.smilecheck.cc.helper.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ci.smilecheck.cc.helper.error.ErrorMessage;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class BasicExceptionResponse extends RuntimeException {

	
	  public BasicExceptionResponse(String msg) {
			
			super(msg);
		}
	  
	  public BasicExceptionResponse(ErrorMessage msg) {
			
			super(msg.toString());
		}
		
}
