package com.example.todoapp.service.post;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

@SpringBootTest
@Transactional
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class PostServiceTest {
    private final PostService postService;

    @Autowired
    public PostServiceTest(PostService postService) {
        this.postService = postService;
    }

    @Test
    @DisplayName("getLastWeekメソッドの動作確認")
    void getLastWeekメソッドの動作確認() {
        LocalDate today = LocalDate.of(2024, 3, 2);
        LocalDate expected = LocalDate.of(2024, 2, 24);
        LocalDate actual = postService.getLastWeek(today);
        assertEquals(expected, actual);
    }
}
