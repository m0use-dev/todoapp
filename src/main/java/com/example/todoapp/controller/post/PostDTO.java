package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;

import java.time.LocalDate;

public record PostDTO(
        int user_id,
        String content,
        String status,
        LocalDate created_at,
        LocalDate updated_at,
        LocalDate deadline
) {
    public static PostDTO toDTO(PostEntity entity) {
        return new PostDTO(
                entity.user_id(),
                entity.content(),
                entity.status(),
                entity.created_at(),
                entity.updated_at(),
                entity.deadline()
        );
    }
}

