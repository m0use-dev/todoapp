package com.example.todoapp.repository.post;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("")
    public void getPostsメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("")
    public void getPostsAllメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("")
    public void getPostメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("")
    public void getContributorメソッドの動作確認() {
        String result = postRepository.getContributor(1);
        assertThat(result).isEqualTo("user1");
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("")
    public void insertPostメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("")
    public void deletePostメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("completionPostメソッドの動作確認")
    public void completionPostメソッドの動作確認() {
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("updatePostメソッドの動作確認")
    public void updatePostメソッドの動作確認() {
    }
}