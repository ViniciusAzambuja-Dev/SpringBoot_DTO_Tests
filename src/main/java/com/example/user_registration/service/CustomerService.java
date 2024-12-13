package com.example.user_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_registration.dto.response.CustomerResponseDTO;
import com.example.user_registration.exception.ResourceNotFoundException;
import com.example.user_registration.mapper.CustomerMapper;
import com.example.user_registration.model.Customer;
import com.example.user_registration.repository.CustomerRepository;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
 
    @Autowired
    private CustomerMapper mapper;

    public CustomerResponseDTO create(Customer customer){
        return mapper.toDTO(customerRepository.save(customer));
    }

    public List<CustomerResponseDTO> getCustomers(){
        List<Customer> list = customerRepository.findAll();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Customers not found");
        }
        else{
            return mapper.toListDTO(list);
        }
    }

    public CustomerResponseDTO getCustomerById(Long customerId){
        return mapper.toDTO(customerRepository.findById(customerId).orElseThrow(
            ()-> new ResourceNotFoundException("Customer not found"))
            );
    }

    public String delete(Long customerId){
        customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found"));
        customerRepository.deleteById(customerId);

        return "Deleted successfully";
    }
}