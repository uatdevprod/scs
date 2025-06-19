package com.StoreCounterSystem.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreCounterSystem.exception.IdNotFoundException;
import com.StoreCounterSystem.models.Product;
import com.StoreCounterSystem.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {

	@Autowired
	ProductRepository repo;

	@Override
	public List<Product> fetch() {
		return repo.findAll();
	}

	@Override
	public List<Product> add(Product product) {
		repo.save(product);
		return repo.findAll();
	}

	@Override
	public List<Product> updateProduct(int productId, Product product) {
		Optional<Product> existingProduct = repo.findById(productId);
		if (!existingProduct.isPresent()) {
			throw new IdNotFoundException("product not found of id : " + productId );
		} else {
			product.setProductId(productId);
			repo.save(product);
			return repo.findAll();
		}
	}

	@Override
	public Optional<Product> delete(int id) {
		Optional<Product> existingProduct = repo.findById(id);
		if (!existingProduct.isPresent()) {
			throw new IdNotFoundException("product cannot be found" + id);
		}
		repo.deleteById(id);
		return existingProduct;
	}

	@Override
	public Optional<Product> findByPrice(int price) {
		Optional<Product> existingProduct = repo.findByPrice(price);
		if (!existingProduct.isPresent()) {
			throw new IdNotFoundException("product not found in the specified range" + price);
		} else {
			return existingProduct;
		}

	}

}
