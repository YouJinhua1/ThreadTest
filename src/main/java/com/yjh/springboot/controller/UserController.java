package com.yjh.springboot.controller;

import com.yjh.springboot.entity.User;
import com.yjh.springboot.service.UserService;
import com.yjh.springboot.utils.UserToken;
import com.yjh.springboot.utils.UserToken1;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
//@Scope("prototype")
public class UserController {

    /**
     * 没有设置：@Scope("prototype")时，模拟高并发访问
     * 浏览器打开两个窗口访问：http://localhost:8088/user/login?username=张三&age=12&gender=女
     *                      http://localhost:8088/user/login?username=张三&age=12&gender=男
     */
    private User user =new User();


    @Resource
    UserService userService;

    @RequestMapping("/login")
    public User Login (@PathParam("user") User user1) throws InterruptedException {
        System.out.println("接收到的参数是："+user1);
        user.setAge(user1.getAge());
        user.setUsername(user1.getUsername());
        user.setGender(user1.getGender());
        Thread.currentThread().sleep(10000);
        System.out.println("最终controller层中user的数据是："+user);
        Thread.currentThread().sleep(10000);
        return user;
    }

    @RequestMapping("/safeLogin")
    public User safeLogin (@PathParam("user") User user1) throws InterruptedException {
        System.out.println("接收到的参数是："+user1);
        UserToken.set("userInfo",user1);
        Thread.currentThread().sleep(10000);
        return test();
    }

    public User test(){
        User user =userService.getUser();
        user.setAge(18);
        System.out.println("----test中-------"+user);
        return user;
    }

    @RequestMapping("/loginToken1")
    public User loginToken1 (@PathParam("user") User user1) throws InterruptedException {
        System.out.println("接收到的参数是："+user1);
        UserToken1.set("userInfo",user1);
        Thread.currentThread().sleep(10000);
        return test1();
    }

    public User test1(){
        User user =userService.getUserByToken1();
        user.setAge(18);
        System.out.println("----test中-------"+user);
        return user;
    }
}
