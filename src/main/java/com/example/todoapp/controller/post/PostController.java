package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("isAuthenticated")
    public String index(Model model) {
        var postList = postService.getPost()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        model.addAttribute("lastWeek", LocalDate.now().minusDays(7));
        model.addAttribute("today", LocalDate.now());
        return "posts/index";
    }

    @GetMapping("/completion")
    @PreAuthorize("isAuthenticated()")
    public String completion() {
        return "posts/completion";
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create() {
        return "posts/create";
    }

    @GetMapping("/edit")
    @PreAuthorize("isAuthenticated()")
    public String edit() {
        return "posts/edit";
    }

    @GetMapping("/delete")
    @PreAuthorize("isAuthenticated()")
    public String delete() {
        return "posts/delete";
    }

}
