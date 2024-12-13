package com.example.user_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_registration.exception.ResourceNotFoundException;
import com.example.user_registration.model.Product;
import com.example.user_registration.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired 
    private ProductRepository productRepository;

    public Product create(Product product){
        return productRepository.save(product);
    }

    public List<Product> getList(){
        List<Product> list = productRepository.findAll();
        
        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Products not found");
        }
        return list;
    }

    public Product getProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(
            () -> new ResourceNotFoundException("Product not found"));
    }

    public String delete(Long productId){
        productRepository.findById(productId).orElseThrow(
            ()-> new ResourceNotFoundException("Product not found")
            );
            
        productRepository.deleteById(productId);

        return "Deleted successfully";
    }
}
