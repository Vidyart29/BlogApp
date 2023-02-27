package com.blogApp.controller;


import com.blogApp.model.User;
import com.blogApp.repository.UserRepository;
import com.blogApp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserRepository userRepository;


    @Autowired
    IUserService userService;

    @RequestMapping(value="/users",method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @RequestMapping(value="/adduser",method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
    public User addUser(@RequestBody User user){
      return  userService.addUser(user);
    }

}
