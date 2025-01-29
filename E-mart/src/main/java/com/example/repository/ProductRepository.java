package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Categories;
import com.example.entity.Product;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    // Find all products by a specific category
    List<Product> findByCategory(Categories category);

}