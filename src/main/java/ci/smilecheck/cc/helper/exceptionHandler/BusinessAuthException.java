package ci.smilecheck.cc.helper.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ci.smilecheck.cc.helper.error.ErrorMessage;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.UNAUTHORIZED)

public class BusinessAuthException extends RuntimeException{
	
	
public BusinessAuthException(String msg) {
		
		super(msg);
	}
	

public BusinessAuthException(ErrorMessage msg) {
	
	super(msg.toString());
 }
}
