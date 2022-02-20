package ci.smilecheck.cc.helper.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import ci.smilecheck.cc.helper.error.ErrorMessage;


@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class BusinessEntityNotFound extends RuntimeException {

   public BusinessEntityNotFound(String msg) {
		
		super(msg);
	}

    public BusinessEntityNotFound(ErrorMessage msg) {
		
		super(msg.toString());
	}
	
}
