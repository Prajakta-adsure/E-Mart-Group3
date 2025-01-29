package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Categories;
import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Add a new product
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    // Get all products
    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // Get product by ID
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        Product product = productService.getProductById(productId);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // Update product details
    @PutMapping("/update/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return updatedProduct != null ? ResponseEntity.ok(updatedProduct) : ResponseEntity.notFound().build();
    }

    // Delete product by ID
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    // Get products by category
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable int categoryId) {
        Categories category = new Categories();
        category.setCategoryId(categoryId); // Assuming Categories has a setter for ID
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }
}