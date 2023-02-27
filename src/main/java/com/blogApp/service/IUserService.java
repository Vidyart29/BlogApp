package com.blogApp.service;

import com.blogApp.model.User;

import java.util.List;

public interface IUserService {
    List getAllUser();

    User getUserById(long id);

    User addUser( User user);

    User deleteUserById(long id);

    User updateUser(User user);
}
