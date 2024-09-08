package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface CategoryService {

	public Category saveCategories(Category category);		

	public Category getCategoriesById(Integer categoryId);
	
	public List<Category> getCategoriesByName();
	
	
	public void deleteById(Integer id);
}
