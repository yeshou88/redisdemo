package com.example.redisdemo.service;

import com.example.redisdemo.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    //根据id查用户信息
    User findById(int id);
}