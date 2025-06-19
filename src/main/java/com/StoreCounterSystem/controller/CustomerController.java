package com.StoreCounterSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StoreCounterSystem.models.Customer;
import com.StoreCounterSystem.service.Customer.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	// fetch product
		@GetMapping("/")
		public ResponseEntity<List<Customer>> fetch() {
			return ResponseEntity.status(HttpStatus.FOUND).body(service.fetch());
		}

		// add product
		@PostMapping("/")
		public ResponseEntity<List<Customer>> add(@RequestBody Customer customer) {
			return ResponseEntity.status(HttpStatus.CREATED).body(service.add(customer));
		}

		// update product
		@PutMapping("/id/{id}")
		public ResponseEntity<List<Customer>> update(@PathVariable("id") int customerId, @RequestBody Customer customer) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(customerId, customer));
		}
}
