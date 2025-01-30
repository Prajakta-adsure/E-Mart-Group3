package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.SubSubcategory;

@Repository
@Transactional
public interface SubSubcategoryRepository extends JpaRepository<SubSubcategory, Integer>{

}
