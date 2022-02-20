package ci.smilecheck.cc.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCustomer;
	
	@Column(unique=true, length=100)
	private String licenceKey;
	
	@Column(unique=true, length=36)
	private String customerName;
	
	private String customerAddresse;
	
	
	private boolean licenceActive=false;
	
	
	@CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getLicenceKey() {
		return licenceKey;
	}

	public void setLicenceKey(String licenceKey) {
		this.licenceKey = licenceKey;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddresse() {
		return customerAddresse;
	}

	public void setCustomerAddresse(String customerAddresse) {
		this.customerAddresse = customerAddresse;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public boolean isLicenceActive() {
		return licenceActive;
	}

	public void setLicenceActive(boolean licenceActive) {
		this.licenceActive = licenceActive;
	}
    
    
    
    
}
