package edu.t1.controller;

import edu.t1.entity.User;
import edu.t1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/readUser/{username}")
    public User readUser(@PathVariable("username") String username) throws SQLException {
        return userService.readUser(username);
    }

    @GetMapping(value = "/user/readAllUser")
    public List<User> readAllUser() throws SQLException {
        return userService.readAllUser();
    }
}
