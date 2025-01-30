package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.SubSubcategory;
import com.example.service.SubSubcategoryService;

@RestController
@RequestMapping("/subsubcategories")
public class SubSubcategoryController {
	
	private final SubSubcategoryService subSubcategoryService;

    @Autowired
    public SubSubcategoryController(SubSubcategoryService subSubcategoryService) {
        this.subSubcategoryService = subSubcategoryService;
    }

    @GetMapping
    public List<SubSubcategory> getAllSubSubcategories() {
        return subSubcategoryService.getAllSubSubcategories();
    }
}

