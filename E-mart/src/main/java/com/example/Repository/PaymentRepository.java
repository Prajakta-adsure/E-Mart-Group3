package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

@Transactional
public interface PaymentRepository extends JpaRepository{

}
