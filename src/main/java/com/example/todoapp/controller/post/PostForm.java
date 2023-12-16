package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import com.example.todoapp.service.user.UserService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

public record PostForm(
        @NotBlank
        @Size(max = 50,message="50文字以内で入力してください")
        String content,

        LocalDate deadline
){
}
