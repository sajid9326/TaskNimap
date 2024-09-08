package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoriesDao;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {

	@Autowired
	private CategoriesDao categDao;

	@Override
	public Category saveCategories(Category category) {
		Category category2 = categDao.save(category);
		return category2;
	}

	@Override
	public Category getCategoriesById(Integer categoryId) {
		Category findById = categDao.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category not exist with id: " + categoryId));
		return findById;
	}

	@Override
	public List<Category> getCategoriesByName() {
		List<Category> findAll = categDao.findAll();
		return findAll;
	}

	@Override
	public void deleteById(Integer id) {
		categDao.deleteById(id);
	}

}
