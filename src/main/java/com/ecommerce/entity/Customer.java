package com.ecommerce.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor	
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String customerEmailId;
	@NonNull
	private String PhoneNumber;
	@OneToMany(targetEntity = Address.class,cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,mappedBy = "customer")
	private List<Address> addresses;
	@OneToMany(targetEntity = Payment.class,cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,mappedBy = "customer")
	private List<Payment> payments;
	@OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,mappedBy = "customer")
	private List<Orders> orders;
	
	

}
