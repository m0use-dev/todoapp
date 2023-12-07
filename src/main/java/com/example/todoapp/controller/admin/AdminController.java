package com.example.todoapp.controller.admin;

import com.example.todoapp.controller.post.PostDTO;
import com.example.todoapp.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final PostService postService;
    @GetMapping
    @PreAuthorize("isAuthenticated")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/posts")
    @PreAuthorize("isAuthenticated")
    public String posts(Model model) {
        var postList = postService.findAll()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        return "admin/posts";
    }

    @GetMapping("/users")
    @PreAuthorize("isAuthenticated")
    public String users() {
        return "admin/users";
    }
}
