package com.example.user_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_registration.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}