package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
	@Modifying
    @Query("UPDATE User u SET u.name = :name, u.email = :email, u.address = :address WHERE u.id = :id")
    int updateUserById(String name, String email, String address, Integer id);

}
