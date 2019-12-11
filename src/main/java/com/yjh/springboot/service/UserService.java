package com.yjh.springboot.service;

import com.yjh.springboot.entity.User;
import com.yjh.springboot.utils.UserToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(){
        return (User) UserToken.get("userInfo");
    }
}
