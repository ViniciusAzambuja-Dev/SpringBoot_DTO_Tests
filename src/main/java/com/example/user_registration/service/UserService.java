package com.example.user_registration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_registration.dto.UserMapper;
import com.example.user_registration.dto.UserResponseDTO;
import com.example.user_registration.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private UserMapper userMapper;

    public UserResponseDTO saveUser(UserResponseDTO userDTO){
        return userMapper.toUserResponseDTO(userRepository.save(userMapper.toUserEntity(userDTO)));
    }

    public List<UserResponseDTO> getUsers(){
        return userMapper.toListResponseDTO(userRepository.findAll());
    }

    public void deleteUserById(int userId){
        userRepository.deleteById(userId);
    }
}