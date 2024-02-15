package com.example.todoapp.controller.user;

import com.example.todoapp.service.user.UserEntity;
import jakarta.validation.constraints.NotNull;

public record UserDTO (
        int id,
        String username,
        String authority
){
    public static UserDTO toDTO(UserEntity entity) {
        return new UserDTO(
                entity.id(),
                entity.username(),
                entity.authority()
        );
    }
}
