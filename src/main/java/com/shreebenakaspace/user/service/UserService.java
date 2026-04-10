package com.shreebenakaspace.user.service;

import com.shreebenakaspace.user.entity.User;
import com.shreebenakaspace.user.repository.UserRepository;
import com.shreebenakaspace.user.repository.UserRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepositoryInterface userRepositoryInterface;

    public User  saveUser(User user){
        return  userRepositoryInterface.save(user);
    }

    public List<User> getAllUser(){
        return userRepositoryInterface.findAll();
    }
}
