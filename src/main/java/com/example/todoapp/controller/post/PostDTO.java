package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;

public record PostDTO(
        int user_id,
        String content,
        String status,
        String created_at,
        String updated_at,
        String deadline
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

