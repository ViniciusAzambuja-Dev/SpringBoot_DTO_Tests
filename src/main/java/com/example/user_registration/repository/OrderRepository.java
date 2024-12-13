package com.example.user_registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.user_registration.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    public List<Order> findByCustomer_CustomerId(Long customerId);
}