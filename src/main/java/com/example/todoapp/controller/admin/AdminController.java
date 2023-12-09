package com.example.todoapp.controller.admin;

import com.example.todoapp.controller.post.PostDTO;
import com.example.todoapp.controller.user.UserDTO;
import com.example.todoapp.service.post.PostService;
import com.example.todoapp.service.user.UserService;
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
    private final UserService userService;
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String index() {
        return "admin/index";
    }

    @GetMapping("/posts")
    @PreAuthorize("hasRole('ADMIN')")
    public String posts(Model model) {
        var postList = postService.getPostAll()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        return "admin/posts";
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public String users(Model model) {
        var userList = userService.getUserAll()
                .stream()
                .map(UserDTO::toDTO)
                .toList();
        model.addAttribute("userList", userList);
        return "admin/users";
    }
}
