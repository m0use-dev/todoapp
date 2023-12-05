package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("permitAll")
    public String list(Model model) {
        var postList = postService.find()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        return "posts/index";
    }

    @GetMapping("/completion")
    @PreAuthorize("permitAll")
    public String completion() {
        return "posts/completion";
    }

    @GetMapping("/create")
    @PreAuthorize("permitAll")
    public String create() {
        return "posts/create";
    }

    @GetMapping("/delete")
    @PreAuthorize("permitAll")
    public String delete() {
        return "posts/delete";
    }

    @GetMapping("/admin")
    @PreAuthorize("permitAll")
    public String admin() {
        return "posts/admin";
    }
}
