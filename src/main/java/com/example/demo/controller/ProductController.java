package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductServices;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/saveProducts")
	public Product saveProductsDetails(@RequestBody Product products) {
		Product saveProducts = productServices.saveProducts(products);
		return saveProducts;
	}
	
	@GetMapping("/{productId}")
	public Product getProductsById(@PathVariable Integer productId) {
		Product recievProductById = productServices.getProductById(productId);
		return recievProductById;
	}
	
	@GetMapping("/")
	public List<Product> getProductsByName() {
		List<Product> recieevProductByName = productServices.getProductByName();
		return recieevProductByName;
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProducts(@PathVariable("id") Integer id,@RequestBody Product product) {
		Product updateProduct = productDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Products not exist with id: " + id));

		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductType(product.getProductType());

		productDao.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }
	
	@DeleteMapping("/{id}")
	public void deletebyId(@PathVariable Integer id) {
		System.out.println(id);
		productServices.deleteById(id);
		
	}
}
