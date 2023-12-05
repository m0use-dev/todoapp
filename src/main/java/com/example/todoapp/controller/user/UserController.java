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
    @PreAuthorize("permitAll")
    public String signup() {
        return "users/signup";
    }

    @RequestMapping("/login")
    @PreAuthorize("permitAll")
    public String login() {
        return "users/login";
    }

    @RequestMapping("/secret")
    @PreAuthorize("permitAll")
    public ModelAndView secret(ModelAndView mav, HttpServletRequest request) {
        String user = request.getRemoteUser();
        String msg = "This is secret page. [login by \"" + user + "\"]";
        mav.setViewName("Secret");
        mav.addObject("title", "Secret page");
        mav.addObject("msg", msg);
        return mav;
    }

}
