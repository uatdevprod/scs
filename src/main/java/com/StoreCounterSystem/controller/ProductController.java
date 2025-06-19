package com.StoreCounterSystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StoreCounterSystem.models.Product;
import com.StoreCounterSystem.service.product.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	// fetch product
	@GetMapping("/")
	public ResponseEntity<List<Product>> fetchProduct() {
		return ResponseEntity.status(HttpStatus.FOUND).body(productService.fetch());
	}

	// add product
	@PostMapping("/")
	public ResponseEntity<List<Product>> add(@RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.add(product));
	}

	// update product
	@PutMapping("/id/{id}")
	public ResponseEntity<List<Product>> update(@PathVariable("id") int productId, @RequestBody Product product) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(productId, product));
	}

	// delete product
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Optional<Product>> delete(@PathVariable("id") int productId) {
		return ResponseEntity.status(HttpStatus.CONTINUE).body(productService.delete(productId));
	}

}
