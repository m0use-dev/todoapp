package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import com.example.todoapp.service.user.UserService;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;

public record PostForm(
        @NotBlank
        @Size(max = 50, message = "50文字以内で入力してください")
        String content,
        @FutureOrPresent(message = "本日以降の日付を設定してください")
        LocalDate deadline
) {
    public static PostForm fromEntity(PostEntity postEntity) {
        return new PostForm(
                postEntity.content(),
                postEntity.deadline()
        );
    }

    public PostEntity toEntity() {
        return new PostEntity(null, null, null, null, null, null, null);
    }
}
