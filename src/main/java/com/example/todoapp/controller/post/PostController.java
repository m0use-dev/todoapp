package com.example.todoapp.controller.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {
    @GetMapping
    public String index() {
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
