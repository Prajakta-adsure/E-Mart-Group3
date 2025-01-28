package com.example.service;



import com.example.entity.Categories;
import com.example.entity.Subcategories;
import com.example.repository.CategoryRepository;
import com.example.repository.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    // Create a new subcategory
    public Subcategories createSubcategory(Subcategories subcategory, int categoryId) {
        Categories category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
        subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }

    // Retrieve all subcategories
    public List<Subcategories> getAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    // Retrieve a subcategory by ID
    public Optional<Subcategories> getSubcategoryById(int subcategoryId) {
        return subcategoryRepository.findById(subcategoryId);
    }

    // Update an existing subcategory
    public Subcategories updateSubcategory(int subcategoryId, Subcategories updatedSubcategory, int categoryId) {
        return subcategoryRepository.findById(subcategoryId)
                .map(existingSubcategory -> {
                    Categories category = categoryRepository.findById(categoryId)
                            .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
                    existingSubcategory.setSubcategoryName(updatedSubcategory.getSubcategoryName());
                    existingSubcategory.setCategory(category);
                    return subcategoryRepository.save(existingSubcategory);
                })
                .orElseThrow(() -> new RuntimeException("Subcategory not found with ID: " + subcategoryId));
    }

    // Delete a subcategory by ID
    public void deleteSubcategory(int subcategoryId) {
        if (subcategoryRepository.existsById(subcategoryId)) {
            subcategoryRepository.deleteById(subcategoryId);
        } else {
            throw new RuntimeException("Subcategory not found with ID: " + subcategoryId);
        }
    }
}
