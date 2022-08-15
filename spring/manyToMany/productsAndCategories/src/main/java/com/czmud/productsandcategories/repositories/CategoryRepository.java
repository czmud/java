package com.czmud.productsandcategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.czmud.productsandcategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	Optional<Category> findById( Long id );
	
	@Query(value="SELECT DISTINCT categories.* FROM categories LEFT JOIN categories_products cp "
			+ "ON cp.category_id=categories.id WHERE cp.category_id NOT IN "
			+ "(SELECT category_id FROM categories_products WHERE product_id = ?1) "
			+ "OR cp.category_id IS NULL;", nativeQuery=true)
	List<Category> getCategoriesNotProductId( Long productId );
}
