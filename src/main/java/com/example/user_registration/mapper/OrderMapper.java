package com.example.user_registration.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.example.user_registration.dto.response.OrderResponseDTO;
import com.example.user_registration.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    public OrderResponseDTO toDTO(Order order); 

    public List<OrderResponseDTO> toListDTO(List<Order> orders);
}
