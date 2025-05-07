package org.example.conference_management.vo;

import org.example.conference_management.pojo.user;

public class userContextHolder {
    private static final ThreadLocal<user> context = new ThreadLocal<>();

    public static void set(user u){
        context.set(u);
    }

    public static user get(){
        return context.get();
    }

    public static void clear(){
        context.remove();
    }
}
