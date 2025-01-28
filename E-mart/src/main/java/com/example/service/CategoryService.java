package com.example.service;

import java.util.List;
import com.example.entity.Product;

public interface CategoryService {
    List<Product> getAllProductsByCategoryId(int cat_id);
}
