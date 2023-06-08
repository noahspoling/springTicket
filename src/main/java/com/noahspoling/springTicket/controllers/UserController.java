package com.noahspoling.springTicket.controllers;

import com.noahspoling.springTicket.lib.user.User;
import com.noahspoling.springTicket.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    //Reference to the Service for user handling
    private final UserService userService;

    @Autowired //Dependency Injection, don't have to instantiate objects (Spring Bean)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
}