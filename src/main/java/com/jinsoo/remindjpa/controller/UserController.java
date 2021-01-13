package com.jinsoo.remindjpa.controller;

import com.jinsoo.remindjpa.model.User;
import com.jinsoo.remindjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all-users")
    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

}
