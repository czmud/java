package com.czmud.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.czmud.productsandcategories.models.Category;
import com.czmud.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	List<Product> findAll();
	
	Optional<Product> findById( Long id );
	
	@Query(value="SELECT DISTINCT products.* FROM products LEFT JOIN categories_products cp "
			+ "ON cp.product_id=products.id WHERE cp.product_id NOT IN "
			+ "(SELECT product_id FROM categories_products WHERE category_id = ?1) "
			+ "OR cp.product_id IS NULL;", nativeQuery=true)
	List<Product> getProductNotCategoryId( Long categoryId );
}
