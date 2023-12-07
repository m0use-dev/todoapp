package com.example.todoapp.service.post;

public record PostEntity(
        int user_id,
        String content,
        String status,
        String created_at,
        String updated_at,
        String deadline
) {
}