package com.example.user_registration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productId") 
    private Product product;

    private Double totalAmount;
    
    private int quantity;

    public Order(){
    }

    public Order(Customer customer, Product product, int quantity){
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = product.getPrice() * quantity;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public Double getTotalAmount(){
        return this.totalAmount;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getCustomerName(){
        return this.customer.getName();
    }

    public String getProductName(){
        return product.getName();
    }
}
