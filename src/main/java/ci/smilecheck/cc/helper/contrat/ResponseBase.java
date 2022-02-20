package  ci.smilecheck.cc.helper.contrat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import  ci.smilecheck.cc.helper.error.ErrorMessage;
/*import lombok.Data;
@Data*/

@JsonInclude(Include.NON_NULL)

public class ResponseBase {

	private boolean hasError;
	private String  errorMessage;
	private String  message;
	private String  info;
	private String  technicalError;
	private Long    totalElements;
	private Integer totalPage;
	private Integer numberOfElements;
	private Integer number ; // correspond à la page courante

	public void setErrorMessage(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage.toString();
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isHasError() {
		return hasError;
	}

	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTechnicalError() {
		return technicalError;
	}

	public void setTechnicalError(String technicalError) {
		this.technicalError = technicalError;
	}

	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Integer numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	
}
