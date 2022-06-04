package com.bottle.service;

import com.bottle.common.Result;
import com.bottle.domain.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> findUsers();

    Result loginUser(User user);
}
