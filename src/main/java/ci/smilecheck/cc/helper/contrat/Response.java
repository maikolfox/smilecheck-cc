package ci.smilecheck.cc.helper.contrat;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response<T> extends ResponseBase{
	
	private T data;
	private ArrayList<T> datas;
	
	public Response(T t) {
		this.data=t;
	}
	
	public Response()
	{
		
	}
	public  Response(Page<T> page) 
	{	
	
		this.setTotalElements(page.getTotalElements());
		this.setDatas( new ArrayList<T>(page.getContent()));
		this.setTotalPage(page.getTotalPages());
		this.setNumber(page.getNumber());
		this.setNumberOfElements(page.getNumberOfElements());
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ArrayList<T> getDatas() {
		return datas;
	}
	public void setDatas(ArrayList<T> datas) {
		this.datas = datas;
	}
	


}