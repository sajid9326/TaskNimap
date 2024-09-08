package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoriesDao categDao;
	
	@PostMapping("/saveCategories")
	public Category saveCategorieDetails(@RequestBody Category category) {
		Category saveCategories = categoryService.saveCategories(category);
		return saveCategories;
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategoriesById(@PathVariable Integer categoryId) {
		Category recievCategoryById = categoryService.getCategoriesById(categoryId);
		return recievCategoryById;
	}
	
	@GetMapping("/")
	public List<Category> getCategoeryByName() {
		List<Category> recievCategoryByName = categoryService.getCategoriesByName();
		return recievCategoryByName;
	}
	
	@PutMapping("{id}")
    public ResponseEntity<Category> updateCategories(@PathVariable Integer id,@RequestBody Category category) {
		Category updateCategories = categDao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not exist with id: " + id));

		updateCategories.setCategory_Name(category.getCategory_Name());
		updateCategories.setCategory_Type(category.getCategory_Type());

		categDao.save(updateCategories);

        return ResponseEntity.ok(updateCategories);
    }
	
	@DeleteMapping("/{id}")
	public void deletebyId(@PathVariable Integer id) {
		System.out.println(id);
		categoryService.deleteById(id);
		
	}
	
}

