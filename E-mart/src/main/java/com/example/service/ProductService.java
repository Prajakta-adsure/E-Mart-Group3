package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {
	
    List<Product> findByCategoryCategoryName(String categoryName);
    List<Product> findBySubcategorySubcategoryName(String subcategoryName);
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    
    
    

}
