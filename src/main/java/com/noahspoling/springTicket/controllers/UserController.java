package com.noahspoling.springTicket.controllers;

import com.noahspoling.springTicket.entity.User;
import com.noahspoling.springTicket.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    //Reference to the Service for user handling
    private final UserService userService;

    @Autowired //Dependency Injection, don't have to instantiate objects (Spring Bean)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<User> getUsers(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @PostMapping(path = "/")
    @ResponseBody()
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping(path = "/")
    @ResponseBody()
    public void updateUser(@RequestBody User user, @RequestBody Map<String, Object> params) throws NoSuchFieldException, IllegalAccessException {
        userService.updateUser(user, params);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody()
    public void deleteUser(@PathVariable("id") long id) {

    }
}
