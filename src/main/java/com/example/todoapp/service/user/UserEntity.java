package com.example.todoapp.service.user;

public record UserEntity(
        int id,
        String username,
        String authority
) {
}
