package com.example.todoapp.service.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class PostServiceTest {
    @Test
    @DisplayName("getLastWeekメソッドの動作確認")
    void getLastWeekメソッドの動作確認() {
        PostService postService = new PostService(null);
        LocalDate today = LocalDate.of(2024, 3, 2);
        LocalDate expected = LocalDate.of(2024, 2, 24);
        LocalDate actual = postService.getLastWeek(today);
        assertEquals(expected, actual);
    }
}
