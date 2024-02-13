package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostDTO(
        @NotNull
        Long id,
        @NotNull
        String user_id,
        @NotNull
        String content,
        @NotNull
        String status,
        @NotNull
        LocalDate created_at,
        @NotNull
        LocalDate updated_at,
        LocalDate deadline
) {
    public static PostDTO toDTO(PostEntity entity) {
        return new PostDTO(
                entity.id(),
                entity.user_id(),
                entity.content(),
                entity.status(),
                entity.created_at(),
                entity.updated_at(),
                entity.deadline()
        );
    }
}

