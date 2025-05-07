package org.example.conference_management.controller;


import org.example.conference_management.entity.User;
import org.example.conference_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/insert")
    public void insert(User user) {
        try {
            userService.insert(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/delete")
    public void delete(int userId) {
        try {
            userService.delete(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/update")
    public void update(int updateUserId, User user) {
        try {
            userService.update(updateUserId,user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping("/select")
    public String select(int userId) {
        return userService.select(userId).toString();
    }
}
