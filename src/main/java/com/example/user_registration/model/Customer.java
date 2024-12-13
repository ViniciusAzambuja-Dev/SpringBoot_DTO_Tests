package com.example.user_registration.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private Long customerId;

    @Column(length = 30)
    private String name;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    private String password;

    @Column(length = 50)
    private String adress;

    public Customer(){}

    public Customer(String name, String email, String password, String adress){
      this.name = name;
      this.email = email;
      this.password = password;
      this.adress = adress;
    }


    public Long getCustomerId() {
      return this.customerId;
    }

    public String getName() {
      return this.name;
    }

    public String getEmail() {
      return this.email;
    }
    
    public String getPassword() {
      return this.password;
    }

    public String getAdress() {
      return this.adress;
    }
}