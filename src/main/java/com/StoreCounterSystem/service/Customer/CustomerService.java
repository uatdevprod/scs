package com.StoreCounterSystem.service.Customer;

import java.util.List;

import com.StoreCounterSystem.models.Customer;
public interface CustomerService {

	public List<Customer> fetch();

	public List<Customer> add(Customer customer);

	public List<Customer> update(int customerId, Customer customer);

}
