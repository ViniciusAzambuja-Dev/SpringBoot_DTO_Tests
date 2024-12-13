package com.example.user_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.user_registration.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
} 
