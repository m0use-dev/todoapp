package com.example.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner.Mode;

@SpringBootApplication
public class ToDoAppApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ToDoAppApplication.class);
        app.setBannerMode(Mode.OFF);
        app.run(args);
    }

}
