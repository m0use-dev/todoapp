package com.example.todoapp.service.post;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

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
    @Test
    @DisplayName("データベースチェック")
    @DatabaseSetup("sampleData.xml")
    void データベースチェック() {
        PostService postService = new PostService(null);
        Optional<PostEntity> expected = postService.getPost(1);
//        Optional<PostEntity> actual = postService.getPost(1);
//        assertEquals(expected, actual);
    }
}
