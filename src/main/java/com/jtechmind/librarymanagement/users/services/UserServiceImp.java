package com.jtechmind.librarymanagement.users.services;

import com.jtechmind.librarymanagement.users.models.User;
import com.jtechmind.librarymanagement.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository repository;

    @Override
    public User addUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new RuntimeException("User Not Found"));
    }
}
