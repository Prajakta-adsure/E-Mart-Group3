package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.entity.Categories;
import com.example.entity.Product;
import com.example.repository.ProductRepository;

public class ProductServiceImpl implements ProductService{
	
	@Autowired
    private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product updateProduct(int productId, Product productDetails) {
		Product existingProduct = productRepository.findById(productId).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(productDetails.getProductName());
            existingProduct.setDescription(productDetails.getDescription());
            existingProduct.setPrice(productDetails.getPrice());
            existingProduct.setStock(productDetails.getStock());
            existingProduct.setCategory(productDetails.getCategory());
            return productRepository.save(existingProduct);
        }
        return null;
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<Product> getProductsByCategory(Categories category) {
		return productRepository.findByCategory(category);
	}

}
