package com.example.user_registration.dto.response;

public class CustomerResponseDTO {
    private final Long customerId;
    private final String name;
    private final String email;
 
    public CustomerResponseDTO(Long customerId, String name, String email){
        this.customerId = customerId;
        this.name = name;
        this.email = email;
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
}
