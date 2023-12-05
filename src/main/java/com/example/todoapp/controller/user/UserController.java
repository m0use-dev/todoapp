package com.example.todoapp.controller.user;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/signup")
    public String signup() {
        return "users/signup";
    }

    @RequestMapping("/login")
    public String login() {
        return "users/login";
    }

    @RequestMapping("/secret")
    public ModelAndView secret(ModelAndView mav, HttpServletRequest request) {
        String user = request.getRemoteUser();
        String msg = "This is secret page. [login by \"" + user + "\"]";
        mav.setViewName("Secret");
        mav.addObject("title", "Secret page");
        mav.addObject("msg", msg);
        return mav;
    }

}
