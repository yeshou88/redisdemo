package com.example.redisdemo.controller;

import com.example.redisdemo.bean.User;
import com.example.redisdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Integer id){
        User user = userService.findById(id);
        return user;
    }
}
