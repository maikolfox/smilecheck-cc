package ci.smilecheck.cc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ci.smilecheck.cc.business.CustomerBusiness;
import ci.smilecheck.cc.helper.contrat.Request;
import ci.smilecheck.cc.helper.contrat.Response;
import ci.smilecheck.cc.model.Customer;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustomerController {

	@Autowired
	private CustomerBusiness customerBusiness;
	
	
	@PostMapping("/customer")
	public Response<?> createCustomer(@RequestBody Request<Customer> request) {
		return customerBusiness.CreateCustomer(request);
	}
	
	@PutMapping("/customer/{licenceKey}")
    public Response<?> updateAgence(@PathVariable String licenceKey) {
		return customerBusiness.ActiveSmileCheck(licenceKey);
	}
	
	@GetMapping("/customer")
	public Response<?> getAllCustomer(Pageable pageable, @RequestParam int pageNo,@RequestParam int pageSize) {
		return customerBusiness.getAllCustomerActif(pageable, pageNo, pageSize);
	
    }
	
			
	@DeleteMapping("/customer")	
	public Response<?> deleteCustomer(@RequestParam Long id) {
			return customerBusiness.desactiveCustomer(id);
	}
		
}
