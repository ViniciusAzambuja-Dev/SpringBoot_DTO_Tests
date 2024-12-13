package com.example.user_registration.mapper;

import java.util.List;
import org.mapstruct.Mapper;

import com.example.user_registration.dto.response.CustomerResponseDTO;
import com.example.user_registration.model.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  
    public CustomerResponseDTO toDTO(Customer customer); 

    public List<CustomerResponseDTO> toListDTO(List<Customer> customers);
}