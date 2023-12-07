package com.example.todoapp.service.post;

import com.example.todoapp.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public List<PostEntity> getPost() {
        return postRepository.getPost();
    }
    public List<PostEntity> getPostAll() {
        return postRepository.getPostAll();
    }

}
