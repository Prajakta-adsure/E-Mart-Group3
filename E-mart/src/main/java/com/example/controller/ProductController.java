package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Get products by category name
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@RequestParam String categoryName) {
        return productService.findByCategoryCategoryName(categoryName);
    }

    // Get products by subcategory name
    @GetMapping("/subcategory/{subcategory}")
    public List<Product> getProductsBySubcategory(@RequestParam String subcategoryName) {
        return productService.findBySubcategorySubcategoryName(subcategoryName);
    }

    // Get products by product name
    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@RequestParam String productName) {
        return productService.findByProductNameContainingIgnoreCase(productName);
    }
}