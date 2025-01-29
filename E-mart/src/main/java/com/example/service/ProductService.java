package com.example.service;

import java.util.List;

import com.example.entity.Categories;
import com.example.entity.Product;

public interface ProductService {
	Product addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int productId);
    Product updateProduct(int productId, Product productDetails);
    void deleteProduct(int productId);
    List<Product> getProductsByCategory(Categories category);

}
