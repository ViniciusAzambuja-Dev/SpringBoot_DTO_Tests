package com.example.user_registration.dto.request;

public class OrderRequestDTO {
    private final Long productId;

    private final int quantity;

    public OrderRequestDTO(Long productId, int quantity){
        this.productId = productId;
        this.quantity = quantity;
    }


    public Long getProductId() {
        return this.productId;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
