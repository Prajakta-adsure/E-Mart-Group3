package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.SubSubcategory;
import com.example.repository.SubSubcategoryRepository;
@Service
public class SubSubcategoryServiceImpl implements SubSubcategoryService{
	
	private final SubSubcategoryRepository subSubcategoryRepository;

    @Autowired
    public SubSubcategoryServiceImpl(SubSubcategoryRepository subSubcategoryRepository) {
        this.subSubcategoryRepository = subSubcategoryRepository;
    }

    @Override
    public List<SubSubcategory> getAllSubSubcategories() {
        return subSubcategoryRepository.findAll(); // or your specific method to fetch the data
    }

}
