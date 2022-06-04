package com.bottle.dao;

import com.bottle.domain.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);
    List<User> selectUsers();
    List<User> loginUser(User user);
}
