package com.yjh.springboot.utils;

import com.yjh.springboot.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserToken {
    private static  final ThreadLocal<Map<Object,Object>> threadLocal=new ThreadLocal<>();

    private UserToken(){

    }
    public static Object get(String attribute){
        Map<Object,Object> userMap=threadLocal.get();
        Object o=null;
        if(userMap!=null){
            o=userMap.get(attribute);
        }
        return o;
    }

    public static <T> T get(String attribute,Class<T> clazz){
        return (T)get(attribute);
    }

    public static void set(Object attribute,Object value){
        Map<Object,Object> userMap=threadLocal.get();
        if(userMap==null){
            userMap=new HashMap<>();
            threadLocal.set(userMap);
        }
        userMap.put(attribute,value);
    }
}
