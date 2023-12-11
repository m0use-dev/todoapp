package com.example.todoapp.service.post;

import java.time.LocalDate;

public record PostEntity(
        int id,
        int user_id,
        String content,
        PostStatus status,
        LocalDate created_at,
        LocalDate updated_at,
        LocalDate deadline
) {
}