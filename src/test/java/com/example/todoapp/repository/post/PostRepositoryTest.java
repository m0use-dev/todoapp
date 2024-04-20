package com.example.todoapp.repository.post;

import com.example.todoapp.service.post.PostEntity;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
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
        var newEntity = new PostEntity(null, "user1", "テスト投稿21", "未完了", LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 25));
        postRepository.insertPost(newEntity);
        Optional<PostEntity> result = postRepository.getPost(21);
        assertThat(result.get().content()).isEqualTo("テスト投稿21");
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("deletePostメソッドの動作確認")
    public void deletePostメソッドの動作確認() {
        // 削除予定のタスクがあるかの確認
        Optional<PostEntity> result = postRepository.getPost(1);
        assertThat(result.get().content()).isEqualTo("テスト投稿1");
        // タスクが削除
        postRepository.deletePost(1);
        // 削除したタスクが空になっているかを確認
        result = postRepository.getPost(1);
        assertThat(result.isPresent()).isFalse();
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("completionPostメソッドの動作確認")
    public void completionPostメソッドの動作確認() {
        int result = postRepository.completionPost(1);
    }

    @Test
    @DatabaseSetup("sampleData.xml")
    @DisplayName("updatePostメソッドの動作確認")
    public void updatePostメソッドの動作確認() {
        // 存在するタスクにupdatePost実行して、内容が変更されているかを確認
        var newEntity = new PostEntity((long) 1, null, "コンテンツ変更", null, null, LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 25));
        postRepository.updatePost(newEntity);
        Optional<PostEntity> result = postRepository.getPost(1);
        assertThat(result.get().content()).isEqualTo("コンテンツ変更");

        // 存在しないタスクにupdatePost実行して、内容が空のままになっているかを確認
        var newEntity2 = new PostEntity((long) 100, null, "コンテンツ変更", null, null, LocalDate.of(2023, 12, 10), LocalDate.of(2023, 12, 25));
        postRepository.updatePost(newEntity2);
        Optional<PostEntity> result2 = postRepository.getPost(100);
        assertThat(result2.isPresent()).isFalse();
    }
}