package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

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
    @DisplayName("getPostsメソッドの動作確認")
    public void getPostsメソッドの動作確認() {
        List<PostEntity> result = postRepository.getPosts("user1");
        assertThat(result.size()).isEqualTo(11);
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("getPostsAllメソッドの動作確認")
    public void getPostsAllメソッドの動作確認() {
        List<PostEntity> result = postRepository.getPostsAll();
        assertThat(result.size()).isEqualTo(20);
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("getPostメソッドの動作確認")
    public void getPostメソッドの動作確認() {
        Optional<PostEntity> result = postRepository.getPost(1);
        assertThat(result.get().content()).isEqualTo("テスト投稿1");
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("getContributorメソッドの動作確認")
    public void getContributorメソッドの動作確認() {
        String result = postRepository.getContributor(1);
        assertThat(result).isEqualTo("user1");
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("insertPostメソッドの動作確認")
    public void insertPostメソッドの動作確認() {

    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("deletePostメソッドの動作確認")
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