package org.example.conference_management.service;

import org.example.conference_management.entity.User;


public interface UserService {
    void insert(User user);

    void delete(int userId);

    void update(int updateUserId, User user);

    User select(int userId);
}
