package com.example.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository repo;
    

    @Override
    public List<Product> getAllProductsByCategoryId(int cat_id) {
        
        return repo.findProductsByCategoryId(cat_id);
    }
}
