package ci.smilecheck.cc.helper.contrat;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class Request<T> {

	@JsonInclude(Include.NON_NULL)
	private T data;
	@JsonInclude(Include.NON_NULL)
	private ArrayList<T> datas;
	
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