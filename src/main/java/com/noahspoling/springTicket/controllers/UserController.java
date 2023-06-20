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
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Optional<User> getUser(@PathVariable("id") long id) {
        return userService.get(id);
    }

    @PostMapping(path = "/")
    @ResponseBody()
    public void addUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping(path = "/{id}")
    @ResponseBody()
    public void updateUser(@PathVariable("id") long id,
                           @RequestBody Map<String, Object> params)
                            throws NoSuchFieldException, IllegalAccessException {
        Optional<User> user = userService.get(id);
        userService.update(user, params);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody()
    public void deleteUser(@PathVariable("id") long id,
                           @RequestBody User user) {
        userService.delete(user);
    }
}
