package com.yjh.springboot.service;

import com.yjh.springboot.entity.User;
import com.yjh.springboot.utils.UserToken;
import com.yjh.springboot.utils.UserToken1;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(){
        return (User) UserToken.get("userInfo");
    }

    public User getUserByToken1(){
        return (User) UserToken1.get("userInfo");
    }
}
