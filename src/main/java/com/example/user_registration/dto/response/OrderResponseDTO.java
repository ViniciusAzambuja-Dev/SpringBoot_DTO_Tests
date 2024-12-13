package com.example.user_registration.dto.response;

public class OrderResponseDTO {
    private final Long orderId;
    private final String customerName;
    private final String productName;
    private final int quantity;
    private final Double totalAmount;
    

    public OrderResponseDTO(Long orderId, String productName, String customerName, Double totalAmount, int quantity){
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getProductName() {
        return this.productName;
    }

    public Double getTotalAmount() {
        return this.totalAmount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getCustomerName() {
        return this.customerName;
    }
}
