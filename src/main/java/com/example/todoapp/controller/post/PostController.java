package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import com.example.todoapp.service.post.PostService;
import com.example.todoapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("isAuthenticated")
    public String index(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.getUserId(username);
        var postList = postService.getPosts(userId)
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        model.addAttribute("lastWeek", LocalDate.now().minusDays(7));
        model.addAttribute("today", LocalDate.now());
        return "posts/index";
    }

    @RequestMapping(value = "/{id}/completion")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String completion(@PathVariable int id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        int userId = userService.getUserId(username);

        int contributorId = postService.getContributor(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (userId == contributorId || hasRoleAdmin) {
            postService.completionPost(id);
            return "redirect:/post?completion";
        } else {
            return "redirect:/error/403";
        }

    }

    @GetMapping("/create")
    @PreAuthorize("isAuthenticated()")
    public String create(@ModelAttribute PostForm form, Model model) {
        return "posts/create";
    }

    @PostMapping("/create")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String createPost(@Validated PostForm form,BindingResult bindingResult ,Model model) {
        if(bindingResult.hasErrors()){
            if(form.deadline() != null ) {
                model.addAttribute("deadlineString", form.deadline().toString());
            }
            return create(form,model);
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.getUserId(username);
        var newEntity = new PostEntity(null, (long) userId, form.content(), "未対応", LocalDate.now(), LocalDate.now(), form.deadline());
        postService.insertPost(newEntity);
        return "redirect:/post?create";
    }

    @GetMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    public String edit(@PathVariable("id") int id, @ModelAttribute PostForm form, Model model) {
        var post = postService.getPost(id)
                .map(PostForm::fromEntity)
                .orElseThrow(PostNotFoundException::new);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.getUserId(username);
        int contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (userId == contributorId || hasRoleAdmin) {
            model.addAttribute("id", id);
            model.addAttribute("postForm", post);
            return "posts/edit";
        } else {
            return "redirect:/error/403";
        }
    }

    @PostMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String editPost(@PathVariable int id, @Validated PostForm form, BindingResult bindingResult,Model model) {
        if(bindingResult.hasErrors()){
            return edit(id,form,model);
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.getUserId(username);
        int contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (userId == contributorId || hasRoleAdmin) {

            var newEntity = new PostEntity((long) id, null, form.content(), null, null, LocalDate.now(), form.deadline());
            postService.updatePost(newEntity);
            return "redirect:/post?update";
        } else {
            return "redirect:/error/403";
        }
    }

    @RequestMapping(value = "/{id}/delete")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String delete(@PathVariable int id) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        int userId = userService.getUserId(username);
        int contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (userId == contributorId || hasRoleAdmin) {
            postService.deletePost(id);
            return "redirect:/post?delete";
        } else {
            return "redirect:/error/403";
        }
    }
}
