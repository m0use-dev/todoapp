package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import com.example.todoapp.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;

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

    @RequestMapping(value="/{id}/completion")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String completion(@PathVariable int id) {
        postService.completionPost(id);
        return "redirect:/post?completion";
    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create(Model model) {
//        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("userName", userName);
//        model.addAttribute("today", LocalDate.now());
        return "posts/create";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String createPost(PostForm form,Model model) {
//        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
//        model.addAttribute("userName", userName);
        LocalDate today = LocalDate.now();
        Long user_id = (long) '1';
        var newEntity =  new PostEntity(null, (long) 1, form.content(), "未対応", LocalDate.parse("2023-11-10"), LocalDate.parse("2023-11-10"),form.deadline());
        postService.insertPost(newEntity);
        return "redirect:/post?create";
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        model.addAttribute("id", id);
        model.addAttribute("userName", userName);
        model.addAttribute("postList", post);
        model.addAttribute("today", LocalDate.now());
        return "posts/edit";
    }

    @PostMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
     @Transactional
    public String editPost(@PathVariable Long id,PostForm form, Model model) {
        LocalDate today = LocalDate.now();
        Long user_id = (long) '1';
        var newEntity =  new PostEntity(id, (long) 1, form.content(), "未対応", LocalDate.parse("2023-11-10"), LocalDate.parse("2023-11-10"),form.deadline());
        postService.updatePost(newEntity);
        return "redirect:/post?update";
    }

    @RequestMapping(value="/{id}/delete")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String delete(@PathVariable int id) {
        postService.deletePost(id);
        return "redirect:/post?delete";
    }

}
