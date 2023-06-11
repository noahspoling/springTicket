package com.noahspoling.springTicket.services;

import com.noahspoling.springTicket.lib.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<Users> getUsers() {
        List<Users> users = new ArrayList<Users>();
        for (int i = 1; i < 6; i++) {
            Users user = new Users("exampleEmail" + i + "@website.com", "password");
            user.setId(i);
            users.add(user);
        }
        return users;
    }
}
