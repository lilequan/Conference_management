package org.example.conference_management.service.impl;

import org.example.conference_management.entity.User;
import org.example.conference_management.mapper.UserMapper;
import org.example.conference_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int userId) {
        try {
            userMapper.delete(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int updateUserId, User user) {
        try {
            userMapper.update(updateUserId,user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User select(int userId) {
        return userMapper.select(userId);
    }
}
