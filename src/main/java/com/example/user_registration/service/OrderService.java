package com.example.user_registration.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_registration.dto.request.OrderRequestDTO;
import com.example.user_registration.dto.response.OrderResponseDTO;
import com.example.user_registration.exception.ResourceNotFoundException;
import com.example.user_registration.mapper.OrderMapper;
import com.example.user_registration.model.Customer;
import com.example.user_registration.model.Order;
import com.example.user_registration.model.Product;
import com.example.user_registration.repository.CustomerRepository;
import com.example.user_registration.repository.OrderRepository;
import com.example.user_registration.repository.ProductRepository;


@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired 
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper mapper;
    
    public OrderResponseDTO create(OrderRequestDTO request, Long customerId){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found"));
        Product product = productRepository.findById(request.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        
        Order order = new Order(customer, product, request.getQuantity());
        return mapper.toDTO(orderRepository.save(order));
    }

    public List<OrderResponseDTO> getOrders(){
        List<Order> list = orderRepository.findAll();
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Orders not found");
        }
        return mapper.toListDTO(list);
    }

    public OrderResponseDTO getOrder(Long orderId){
        return mapper.toDTO(orderRepository.findById(orderId).orElseThrow(
            () -> new ResourceNotFoundException("Order not found"))
            );
    }

    public List<OrderResponseDTO> getOrdersByCustomer(Long customerId){
        List<Order> list = orderRepository.findByCustomer_CustomerId(customerId);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Orders Not Found");
        }
        return mapper.toListDTO(list);
    }

    public String delete(Long orderId){
        orderRepository.findById(orderId).orElseThrow(
            ()-> new ResourceNotFoundException("Order not found")
            );

        orderRepository.deleteById(orderId);

        return "Deleted successfully";
    }
}
