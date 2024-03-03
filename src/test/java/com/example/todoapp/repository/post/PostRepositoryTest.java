package com.example.todoapp.repository.post;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {
    private final PostRepository postRepository;

    @Autowired
    public PostRepositoryTest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    public void getContributorメソッドの動作確認() {
        String result = postRepository.getContributor(1);
        assertThat(result).isEqualTo("user1");
    }

}