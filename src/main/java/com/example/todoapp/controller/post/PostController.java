package com.example.todoapp.controller.post;

import com.example.todoapp.service.post.PostEntity;
import com.example.todoapp.service.post.PostService;
import jakarta.servlet.http.HttpServletRequest;
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

import java.net.MalformedURLException;
import java.time.LocalDate;


@Controller
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    @PreAuthorize("isAuthenticated")
    public String index(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var postList = postService.getPosts(username)
                .stream()
                .map(PostDTO::toDTO)
                .toList();
        model.addAttribute("postList", postList);
        LocalDate today = LocalDate.now();
        model.addAttribute("today", today);
        LocalDate nextWeek = postService.getNextWeek(today);
        model.addAttribute("nextWeek", nextWeek);
        return "posts/index";
    }

    @RequestMapping(value = "/{id}/completion")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String completion(@PathVariable int id, HttpServletRequest request) throws MalformedURLException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String contributorId = postService.getContributor(id);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (username == contributorId || hasRoleAdmin) {
            postService.completionPost(id);
            String referer = request.getHeader("Referer");
            if (referer.matches(".*/admin/posts.*$")) {
                return "redirect:/admin/posts?completion";
            } else {
                return "redirect:/post?completion";
            }
        } else {
            return "/error/403";
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
    public String createPost(@Validated PostForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return create(form, model);
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var newEntity = new PostEntity(null, username, form.content(), "未完了", LocalDate.now(), LocalDate.now(), form.deadline());
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
        String contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (username == contributorId || hasRoleAdmin) {
            model.addAttribute("id", id);
            model.addAttribute("postForm", post);
            return "posts/edit";
        } else {
            return "/error/403";
        }
    }

    @PutMapping("/{id}/edit")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String editPost(@PathVariable int id, @Validated PostForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("postForm", form);
            return "posts/edit";
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (username == contributorId || hasRoleAdmin) {
            var newEntity = new PostEntity((long) id, null, form.content(), null, null, LocalDate.now(), form.deadline());
            postService.updatePost(newEntity);
            if (username == contributorId) {
                return "redirect:/post?update";
            } else {
                return "redirect:/admin/posts?update";
            }
        } else {
            return "/error/403";
        }
    }

    @RequestMapping(value = "/{id}/delete")
    @PreAuthorize("isAuthenticated()")
    @Transactional
    public String delete(@PathVariable int id, HttpServletRequest request) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String contributorId = postService.getContributor(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean hasRoleAdmin = authentication.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
        if (username == contributorId || hasRoleAdmin) {
            postService.deletePost(id);
            String referer = request.getHeader("Referer");
            if (referer.matches(".*/admin/posts.*$")) {
                return "redirect:/admin/posts?delete";
            } else {
                return "redirect:/post?delete";
            }
        } else {
            return "/error/403";
        }
    }
}
