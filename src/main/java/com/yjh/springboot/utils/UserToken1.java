package com.yjh.springboot.utils;

import java.util.HashMap;
import java.util.Map;

public class UserToken1 {

    private static  final Map<Object,Object> map=new HashMap<>();

    private UserToken1(){

    }
    public static Object get(String attribute){
        return map.get(attribute);
    }

    public static <T> T get(String attribute,Class<T> clazz){
        return (T)get(attribute);
    }

    public static void set(Object attribute,Object value){
        map.put(attribute,value);
    }
}
