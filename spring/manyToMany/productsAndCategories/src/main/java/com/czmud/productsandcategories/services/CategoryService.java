package com.czmud.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czmud.productsandcategories.models.Category;
import com.czmud.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	public Category saveNewCategory( Category newCategory ) {
		return categoryRepository.save( newCategory );
	}
	
	public Category getCategoryById( Long categoryId ) {
		
		Optional<Category> checkForCategory = categoryRepository.findById( categoryId );
		if( checkForCategory.isEmpty() ) {
			return null;
		}
		
		return checkForCategory.get();
		
	}
	
	public List<Category> getCategoriesNotInProduct( Long productId ) {
		return categoryRepository.getCategoriesNotProductId( productId );
	}
	
}
