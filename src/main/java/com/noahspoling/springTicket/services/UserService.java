package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.lib.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        for (int i = 1; i < 6; i++) {
            User user = new User("exampleEmail" + i + "@website.com", "password");
            user.setId(i);
            users.add(user);
        }
        return users;
    }
}
