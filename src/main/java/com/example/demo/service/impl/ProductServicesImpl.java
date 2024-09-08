package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product saveProducts(Product product) {
		Product product2 = productDao.save(product);
		return product2;
	}

	@Override
	public Product getProductById(Integer productId) {
		Product productIds = productDao.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + productId));
        
		return productIds;
	}

	@Override
	public List<Product> getProductByName() {
		List<Product> findAll = productDao.findAll();
		return findAll;
	}

	@Override
	public void deleteById(Integer productId) {

		productDao.deleteById(productId);
	}

}
