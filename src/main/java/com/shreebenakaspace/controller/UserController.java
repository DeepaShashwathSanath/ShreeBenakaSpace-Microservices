package com.shreebenakaspace.controller;

import com.shreebenakaspace.model.User;
import com.shreebenakaspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
/*@Autowired
    UserService userServic;*/

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
    return userService.getAllUsers();
    }
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);}
}

