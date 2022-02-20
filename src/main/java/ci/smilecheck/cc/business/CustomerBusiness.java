package ci.smilecheck.cc.business;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ci.smilecheck.cc.helper.contrat.Request;
import ci.smilecheck.cc.helper.contrat.Response;
import ci.smilecheck.cc.helper.error.ErrorMessage;
import ci.smilecheck.cc.helper.exceptionHandler.BusinessBadRequest;
import ci.smilecheck.cc.model.Customer;
import ci.smilecheck.cc.repository.CustomerRepository;

@Service
public class CustomerBusiness {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Response<Customer> CreateCustomer(Request<Customer> request){
		
		try {	
			
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
		catch(Exception e) {
			
			
			throw new  BusinessBadRequest( ErrorMessage.ERROR_SERVEUR_500);
	
		}
	
	} 


	
	
	
public Response<?> ActiveSmileCheck(String licenceKey){
		
		
		try {
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
				findCustom.setLicenceActive(false);
				customerRepository.save(findCustom);
				
				Response<Customer> response =new Response<Customer>();
				response.setHasError(false);
				response.setErrorMessage(ErrorMessage.SUCCESS_CUSTOMER_LICENCE_ACTIVATION);
				response.setData(customer);
				return response;
			}else {
				
				throw new  BusinessBadRequest( ErrorMessage.ERROR_CUSTOMER_BAD_LICENCE);
	
			}
			
		
		}
		catch(Exception e) {
			
			
			throw new  BusinessBadRequest(ErrorMessage.ERROR_SERVEUR_500);

		}
		
	   
	} 



}
