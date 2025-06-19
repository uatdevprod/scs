package com.StoreCounterSystem.service.product;

import java.util.List;
import java.util.Optional;

import com.StoreCounterSystem.models.Product;

public interface ProductService {

	public List<Product> fetch();

	public List<Product> add(Product product);

	public List<Product> updateProduct(int id, Product product);

	public Optional<Product> findByPrice(int price);

	public Optional<Product> delete(int id);

}
