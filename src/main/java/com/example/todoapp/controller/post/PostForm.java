package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PostForm(
        @NotBlank
        @Size(max = 256,message="256文字以内で入力してください")
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
