package com.example.todoapp.service.post;

import java.time.LocalDate;

public record PostEntity(
        Long id,
        String username,
        String content,
        String status,
        LocalDate created_at,
        LocalDate updated_at,
        LocalDate deadline
) {
}