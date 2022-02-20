package ci.smilecheck.cc.helper.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ci.smilecheck.cc.helper.error.ErrorMessage;


@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BusinessBadRequest extends RuntimeException{
	

public BusinessBadRequest(String msg) {
		
		super(msg);
	}
	

public BusinessBadRequest(ErrorMessage msg) {
	
	super(msg.toString());
 }
}
