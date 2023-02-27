package com.blogApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogpostController {

    @GetMapping("/blogpost")
    public String BlogApp(){
        System.out.println("asdfghj");
        return "blog app mapped";
    }



}
