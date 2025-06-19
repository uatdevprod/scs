package com.StoreCounterSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreCounterSystem.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
