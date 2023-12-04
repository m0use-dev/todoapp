package com.example.todoapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SampleSecurityController {

//    @RequestMapping("/")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/admin")
//    public String admin() {
//        return "admin";
//    }
//
//    @RequestMapping("/completion")
//    public String completion() {
//        return "completion";
//    }
//
//    @RequestMapping("/create")
//    public String create() {
//        return "create";
//    }
//
//    @RequestMapping("/delete")
//    public String delete() {
//        return "delete";
//    }
//
//    @RequestMapping("/signup")
//    public String signup() {
//        return "index";
//    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/secret")
//    public ModelAndView secret(ModelAndView mav, HttpServletRequest request) {
//        String user = request.getRemoteUser();
//        String msg = "This is secret page. [login by \"" + user + "\"]";
//        mav.setViewName("Secret");
//        mav.addObject("title", "Secret page");
//        mav.addObject("msg", msg);
//        return mav;
//    }
}