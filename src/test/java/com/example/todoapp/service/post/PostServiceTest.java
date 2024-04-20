package com.example.todoapp.service.post;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@SpringBootTest
public class PostServiceTest {
    private final PostService postService;

    @Autowired
    public PostServiceTest(PostService postService) {
        this.postService = postService;
    }

    @Test
    @DisplayName("getNextWeekメソッドの動作確認")
    void getNextWeekメソッドの動作確認() {
        LocalDate today = LocalDate.of(2024, 2, 24);
        LocalDate expected = LocalDate.of(2024, 3, 2);
        LocalDate actual = postService.getNextWeek(today);
        assertEquals(expected, actual);
    }
}
