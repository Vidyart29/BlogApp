package com.blogApp.service;

import com.blogApp.model.User;
import com.blogApp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        System.out.println("user working");
        return users;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }


    public User addUser(User user){
       return userRepository.save(user);

    }

    @Override
    public User deleteUserById(long id) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }


}
