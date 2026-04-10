package com.shreebenakaspace.user.controller;

import com.shreebenakaspace.user.dto.UserDTO;
import com.shreebenakaspace.user.entity.User;
import com.shreebenakaspace.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


/*
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
*/
    @PostMapping
    public UserDTO createUser(@Valid  @RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }


    //Get UserBy Id
@GetMapping("/{id}")
    public  UserDTO getUser(@PathVariable Long id){
    return  userService.getUserById(id);
    }


//Get ALl User
    /*    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }*/

@GetMapping
    public List<UserDTO>  getAllUsers(){
    return userService.getAllUsers();
}
//Update User
    @PutMapping("/{id}")
    public UserDTO  updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
    return userService.updateUser(id,userDTO);

    }

    //Delete  User
    @DeleteMapping
    public String deleteUser(@PathVariable Long id){
            userService.deleteUser(id);
            return "Deleted successfully";
    }



}
