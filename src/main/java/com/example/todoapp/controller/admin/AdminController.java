package com.example.todoapp.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/posts")
    @PreAuthorize("hasRole('ADMIN')")
    public String posts() {
        return "admin/posts";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String users() {
        return "admin/users";
    }
}
