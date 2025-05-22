package org.example.conference_management.vo;

import org.example.conference_management.pojo.User;

public class userContextHolder {
    private static final ThreadLocal<User> context = new ThreadLocal<>();

    public static void set(User u){
        context.set(u);
    }

    public static User get(){
        return context.get();
    }

    public static void clear(){
        context.remove();
    }
}
