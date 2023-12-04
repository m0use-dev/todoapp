package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String list(Model model){
        var postList = postService.find()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        return "posts/index";
    }

    @GetMapping("/completion")
    public String completion() {
        return "posts/completion";
    }

    @GetMapping("/create")
    public String create() {
        return "posts/create";
    }

    @GetMapping("/delete")
    public String delete() {
        return "posts/delete";
    }

    @GetMapping("/admin")
    public String admin() {
        return "posts/admin";
    }
}
