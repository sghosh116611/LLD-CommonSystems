package Splitwise.controller;

import Splitwise.entity.User;

import java.util.List;

public class UserController {

    private static List<User> users;

    public User addUser(User user){
        users.add(user);
        return user;
    }
}
