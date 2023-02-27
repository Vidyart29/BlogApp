package com.blogApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @GetMapping("/")
    public String BlogApp(){
        return "blog app mapped";
    }

}
