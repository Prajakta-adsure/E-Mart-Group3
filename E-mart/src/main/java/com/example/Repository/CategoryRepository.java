package com.example.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Product;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Product, Integer> {

	
	@Query(value = "select * from Product p where p.CategoryID = :cat_id", nativeQuery = true)
	List<Product> findProductsByCategoryId(@Param("cat_id") int cat_id);


	

}

