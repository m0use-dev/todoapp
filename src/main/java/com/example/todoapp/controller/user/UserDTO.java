package com.example.todoapp.controller.user;

import com.example.todoapp.service.user.UserEntity;
import jakarta.validation.constraints.NotNull;

public record UserDTO (
        @NotNull
        int id,
        @NotNull
        String username,
        @NotNull
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
