package com.StoreCounterSystem.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Profile profile;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	private String paymentType;
	
	private int totalAmount;
	
	@CreationTimestamp
	private Date createdDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Product> purchasedItems;
	
	private double taxAmount;
}
