package com.example.todoapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping
    @PreAuthorize("permitAll")
    public String index() {
        return "index";
    }
}
