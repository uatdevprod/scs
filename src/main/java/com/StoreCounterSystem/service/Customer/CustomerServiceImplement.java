package com.StoreCounterSystem.service.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreCounterSystem.exception.IdNotFoundException;
import com.StoreCounterSystem.models.Customer;
import com.StoreCounterSystem.repository.CustomerRepository;

@Service
public class CustomerServiceImplement implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<Customer> fetch() {
		return repo.findAll();
	}

	@Override
	public List<Customer> add(Customer customer) {
		repo.save(customer);
		return repo.findAll();
	}

	@Override
	public List<Customer> update(int customerId, Customer customer) {
		Optional<Customer> existingProduct = repo.findById(customerId);
		if (!existingProduct.isPresent()) {
			throw new IdNotFoundException("customer not found of id : " + customerId );
		} else {
			customer.setId(customerId);
			repo.save(customer);
			return repo.findAll();
		}
	}

}
