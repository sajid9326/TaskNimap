package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductServices {

	public Product saveProducts(Product product);		

	public Product getProductById(Integer productId);
	
	public List<Product> getProductByName();
	
	public void deleteById(Integer productId);
}
