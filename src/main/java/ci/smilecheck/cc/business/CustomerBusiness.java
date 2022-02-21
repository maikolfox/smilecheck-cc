package ci.smilecheck.cc.business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ci.smilecheck.cc.helper.contrat.Request;
import ci.smilecheck.cc.helper.contrat.Response;
import ci.smilecheck.cc.helper.dto.CustomerDto;
import ci.smilecheck.cc.helper.error.ErrorMessage;
import ci.smilecheck.cc.helper.exceptionHandler.BusinessBadRequest;
import ci.smilecheck.cc.helper.exceptionHandler.BusinessEntityNotFound;
import ci.smilecheck.cc.model.Customer;
import ci.smilecheck.cc.repository.CustomerRepository;



@Service
public class CustomerBusiness {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	// ALL CUSTOMER PAGINATION
		public Response<Customer> getAllCustomerActif(Pageable pageable, int pageNo, int pageSize) {

			pageable = PageRequest.of(pageNo, pageSize, Sort.by("idCustomer").ascending());
			Page<Customer> datas = customerRepository.findAll(pageable);

			List<Customer> listCustomer = datas.getContent();

			ArrayList<Customer> aListCustomer= new ArrayList<Customer>();

			Response<Customer> responseDto = new Response<Customer>(datas);
			// a optimiser pour obtenir un array list sans faire une boucle
			for(Customer custom : listCustomer) {
				
				aListCustomer.add(custom);
			}

			responseDto.setTotalPage(datas.getTotalPages());
			responseDto.setNumberOfElements(datas.getNumberOfElements());
			responseDto.setNumber(datas.getNumber());
			responseDto.setTotalElements(datas.getTotalElements());
			responseDto.setDatas(aListCustomer);

			responseDto.setHasError(false);
			responseDto.setErrorMessage("");
			return responseDto;
		}
	
		
	public 	Response<Customer> desactiveCustomer(Long id){
		
		if(id==null) {
			throw new BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_IDNULL);
		}
		
		Customer findCust =customerRepository.findByIdCustomer(id);
		
		if(findCust==null) {
			
			throw new BusinessEntityNotFound(ErrorMessage.ERROR_CUSTOMER_NOTFOUND);
		}
		
		
		customerRepository.delete(findCust);
		
		
		Response<Customer> response =new Response<Customer>();
		
		response.setHasError(false);
		response.setErrorMessage(ErrorMessage.SUCCES_DELETE);
		response.setData(null);
		
		return response ;

		
	}
	
	//DONE
	public Response<Customer> CreateCustomer(Request<Customer> request){
		
			
				Customer customer=request.getData();
		
				
				if(customer==null) {
					throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_NAME);
				}
				
				
				//Customer name validation
				if(customer.getCustomerName().trim().equals("")  || 
				   customer.getCustomerName().length()>100) {
					throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_NAME);
				}
			
				Customer findCustom= customerRepository.findByCustomerName(customer.getCustomerName());
				
				
				if(findCustom!=null) {
					
					throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_NAME_ALREADY_ASSIGN);
				}
				
				//Customer address validation
				if(customer.getCustomerAddresse()==null || 
				   customer.getCustomerAddresse().trim().equals("")  || 
				   customer.getCustomerAddresse().length()>255) {
				   throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_ADRESS);
				}

				
				UUID licenceKey=UUID.randomUUID();
				customer.setLicenceKey(licenceKey);
				
				
				
				//Return response
				
				customerRepository.save(customer);
				
				Response<Customer> response =new Response<Customer>();
			
				response.setHasError(false);
				response.setErrorMessage(ErrorMessage.SUCCESS_CREATE);
				response.setData(customer);
				
				return response;
		
		
	
	
	} 


	
//done
	public Response<?> ActiveSmileCheck(String licenceKey){
		
		
	
		    //do controle :
		
			Customer customer= new Customer();
			customer.setLicenceKey(UUID.fromString(licenceKey));
			
			
			
			// check if username not existe -->
			
			if(customer.getLicenceKey()==null  ) {
				throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_BAD_LICENCE);
			}
			
			Customer findCustom= customerRepository.findByLicenceKey(customer.getLicenceKey());
	
			if(findCustom==null || findCustom.isLicenceActive() ) {
				throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_BAD_LICENCE);			
			}
			
			
			if(! findCustom.isLicenceActive() ) {
				
				//Activez la licence
				findCustom.setLicenceActive(true);
				findCustom.setUpdatedAt(LocalDateTime.now());
				customerRepository.save(findCustom);
				
				Response<Customer> response =new Response<Customer>();
				response.setHasError(false);
				response.setErrorMessage(ErrorMessage.SUCCESS_CUSTOMER_LICENCE_ACTIVATION);
				response.setData(findCustom);
				return response;
			}else {
				
				throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_BAD_LICENCE);
	
			}
			
		
		

		
	   
	} 



}
