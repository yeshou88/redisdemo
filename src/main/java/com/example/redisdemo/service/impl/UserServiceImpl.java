package com.example.redisdemo.service.impl;

import com.example.redisdemo.bean.User;
import com.example.redisdemo.mapper.UserMapper;
import com.example.redisdemo.service.IUserService;
import com.example.redisdemo.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    User user;
    @Autowired
    UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User findById(int id) {
        String key = "user"+id;
        if(redisUtil.hasKey(key)) {
            user = (User)redisUtil.get(key);
            System.out.println("查询的是缓存");
        }else{
            user = userMapper.findById(id);
            System.out.println("查询的是数据库");
            System.out.println(redisUtil.set(key,user) ? "插入成功" : "插入失败");
        }
        return user;
    }
}
