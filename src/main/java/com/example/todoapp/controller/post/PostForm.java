package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostForm(
        String content,
        LocalDate deadline
){
//    public static PostForm PostEntity(PostEntity formEntity) {
//        return new PostForm(
//                formEntity.content(),
//                formEntity.deadline()
//        );
//    }

//    public PostEntity toEntity() {
//        return new PostEntity(null,user_id(),content(),null,created_at(),updated_at(),deadline());
//    }
}
