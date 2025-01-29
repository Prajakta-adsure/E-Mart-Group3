
	package com.example.repository;

	import com.example.entity.Cart;
import com.example.entity.Product;
import com.example.entity.User;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import java.util.List;
import java.util.Optional;

	@Repository
	public interface CartRepository extends JpaRepository<Cart, Integer> {
	    List<Cart> findByUser(User user); // Retrieve cart items by user
	    Optional<Cart> findByUserAndProduct(User user, Product product);
	
}
