package com.jtechmind.librarymanagement.users.services;

import com.jtechmind.librarymanagement.users.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> findAllUsers();
    User findUserById(Long id);
}
