package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("isAuthenticated")
    public String index(Model model) {
        var postList = postService.getPosts()
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        model.addAttribute("lastWeek", LocalDate.now().minusDays(7));
        model.addAttribute("today", LocalDate.now());
        return "posts/index";
    }

    @GetMapping("/{id}/completion")
    @PreAuthorize("isAuthenticated()")
    public String completion(@PathVariable int id) {

        return "posts/completion";
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create(@PathVariable int id) {
        return "posts/create";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String edit(@PathVariable int id, Model model) {
        var post = postService.getPost(id)
                .stream()
                .map(PostDTO::toDTO)
                .toList();
//        if (post == null) {
//            return "";
//        }
        model.addAttribute("postList", post);
        return "posts/edit";
    }

    @GetMapping("/{id}/delete")
    @PreAuthorize("isAuthenticated()")
    public String delete(@PathVariable int id) {
        return "posts/delete";
    }

}
