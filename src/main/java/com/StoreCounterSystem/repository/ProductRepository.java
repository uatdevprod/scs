package com.StoreCounterSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StoreCounterSystem.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public Optional<Product> findByPrice(int price);

}
