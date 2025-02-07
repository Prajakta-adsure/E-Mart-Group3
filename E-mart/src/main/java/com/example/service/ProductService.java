package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Product;

public interface ProductService {
    
    List<Product> findByCategoryCategoryName(String categoryName);
    List<Product> findBySubcategorySubcategoryName(String subcategoryName);
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    Optional<Product> findByProductId(Long productId);  // Added method to fetch product by ID
}
