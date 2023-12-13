package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostForm(
//        int user_id,
        String content,
//        LocalDate created_at,
//        LocalDate updated_at,
        LocalDate deadline
){
//    public static PostForm PostEntity(PostEntity formEntity) {
//        return new PostForm(
//                formEntity.user_id(),
//                formEntity.content(),
//                formEntity.created_at(),
//                formEntity.updated_at(),
//                formEntity.deadline()
//        );
//    }


//    public PostEntity toEntity() {
//        return new PostEntity(null,user_id(),content(),null,created_at(),updated_at(),deadline());
//    }
}
