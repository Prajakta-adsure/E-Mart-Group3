package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,Integer> {
	 List<Product> findByCategoryCategoryName(String categoryName);

	    // Find products by subcategory name (assuming the subcategory has a 'subcategoryName' field)
	    List<Product> findBySubcategorySubcategoryName(String subcategoryName);

	    // Find products by product name (using 'productName' as it's defined in the entity)
	    List<Product> findByProductNameContainingIgnoreCase(String productName);
}
