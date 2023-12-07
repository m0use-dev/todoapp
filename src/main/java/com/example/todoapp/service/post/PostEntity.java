package com.example.todoapp.service.post;
import java.time.LocalDate;

public record PostEntity(
        int user_id,
        String content,
        String status,
        LocalDate created_at,
        LocalDate updated_at,
        LocalDate deadline
) {
}