package com.czmud.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czmud.productsandcategories.models.Category;
import com.czmud.productsandcategories.models.Product;
import com.czmud.productsandcategories.repositories.CategoryRepository;
import com.czmud.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Product> getAllProducts() {		
		return productRepository.findAll();
	}
	
	public Product saveNewProduct( Product newProduct ) {
		return productRepository.save( newProduct );
	}
	
	public Product getProductById( Long productId ) {
		
		
		Optional<Product> checkForProduct = productRepository.findById( productId );
		if ( checkForProduct.isEmpty() ) {
			return null;
		}
		
		return checkForProduct.get();
	}
	
	public List<Product> getProductsNotInCategory( Long categoryId ){
		return productRepository.getProductNotCategoryId( categoryId );
	}
	
	public void addCategoryToProduct( Long categoryId, Long productId) {
		
		Optional<Product> checkForProduct = productRepository.findById( productId );
		if ( checkForProduct.isEmpty() ) {
			return;
		}
		
		Product updateProduct = checkForProduct.get();
		
		Optional<Category> checkForCategory = categoryRepository.findById( categoryId );
		if( checkForCategory.isEmpty() ) {
			return;
		}
		
		updateProduct.getCategories().add( checkForCategory.get() );
		
		productRepository.save( updateProduct );
		
		return;
	}
	
}
