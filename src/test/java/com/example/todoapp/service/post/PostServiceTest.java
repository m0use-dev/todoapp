package com.example.todoapp.service.post;

import com.example.todoapp.repository.post.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@SpringBootTest
public class PostServiceTest {
    @Autowired
    private PostService postService;

    @MockBean
    private PostRepository postRepository;

    @Test
    @Transactional
    @DisplayName("getLastWeekメソッドの動作確認")
    void getLastWeekメソッドの動作確認() {
        LocalDate today = LocalDate.of(2024, 3, 2);
        LocalDate expected = LocalDate.of(2024, 2, 24);
        LocalDate actual = postService.getLastWeek(today);
        assertEquals(expected, actual);
    }
//    @Test
//    @Transactional
//    @DisplayName("データベースチェック")
//    void データベースチェック() {
//        var expected = postService.getPost(1);
//    }
}
