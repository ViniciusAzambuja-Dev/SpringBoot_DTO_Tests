package com.example.user_registration.dto;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.example.user_registration.model.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    public UserEntity toUserEntity(UserResponseDTO userDTO);

    public UserResponseDTO toUserResponseDTO(UserEntity userEntity); 

    public List<UserResponseDTO> toListResponseDTO(List<UserEntity> listUserEntity);
}
