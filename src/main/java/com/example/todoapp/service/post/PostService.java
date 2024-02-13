package com.example.todoapp.service.post;

import com.example.todoapp.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostEntity> getPosts(String username) {
        return postRepository.getPosts(username);
    }

    public List<PostEntity> getPostsAll() {
        return postRepository.getPostsAll();
    }

    public Optional<PostEntity> getPost(long id) {
        return postRepository.getPost(id);
    }

    public int completionPost(int id) {
        return postRepository.completionPost(id);
    }

    public int deletePost(int id) {
        return postRepository.deletePost(id);
    }

    @Transactional
    public int insertPost(PostEntity newEntity) {
        return postRepository.insertPost(newEntity);
    }

    @Transactional
    public int updatePost(PostEntity newEntity) {
        return postRepository.updatePost(newEntity);
    }

    public String getContributor(int id) {
        return postRepository.getContributor(id);
    }
}
