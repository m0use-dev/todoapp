package com.example.todoapp.service.post;

import com.example.todoapp.repository.post.PostRepository;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

public class PostServiceTest {
    @Autowired
    private PostService postService = new PostService(null);

    @Test
    @DisplayName("getLastWeekメソッドの動作確認")
    void getLastWeekメソッドの動作確認() {
        LocalDate today = LocalDate.of(2024, 3, 2);
        LocalDate expected = LocalDate.of(2024, 2, 24);
        LocalDate actual = postService.getLastWeek(today);
        assertEquals(expected, actual);
    }

}
