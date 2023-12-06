package com.example.todoapp.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signup")
    @PreAuthorize("isAnonymous()")
    public String signup() {
        return "users/signup";
    }

    @RequestMapping("/login")
    @PreAuthorize("isAnonymous()")
    public String login() {
        return "users/login";
    }
}
