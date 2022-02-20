package ci.smilecheck.cc.repository;


import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.smilecheck.cc.model.Customer;

@Repository
@Transactional
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

	
	
	Customer findByCustomerName(String customerName);
	Customer findByLicenceKey(UUID licencKey);
}
