package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findByCategoryCategoryName(String categoryName) {
        // Fetch products by category name using the repository method
        return productRepository.findByCategoryCategoryName(categoryName);
    }

    @Override
    public List<Product> findBySubcategorySubcategoryName(String subcategoryName) {
        // Fetch products by subcategory name using the repository method
        return productRepository.findBySubcategorySubcategoryName(subcategoryName);
    }

    @Override
    public List<Product> findByProductNameContainingIgnoreCase(String productName) {
        // Fetch products by product name using the repository method with case-insensitive search
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }

    @Override
    public Optional<Product> findByProductId(Long productId){
        return productRepository.findByProductId(productId);  // Use 'productId' here
    }
    
}
