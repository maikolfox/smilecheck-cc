package ci.smilecheck.cc.repository;


import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ci.smilecheck.cc.model.Customer;

@Repository
@Transactional
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

	
	
	Customer findByCustomerName(String customerName);
	Customer findByIdCustomer(Long id);
	Customer findByLicenceKey(UUID licencKey);
	//Page<Customer> findAll(Pageable page);
}
