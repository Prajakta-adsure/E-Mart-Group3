package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Categories;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/api/categories")  // Base URL for category-related endpoints
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")  // Get all categories
    public ResponseEntity<List<Categories>> getCategories() {
        List<Categories> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories); // Return only categories
    }
}