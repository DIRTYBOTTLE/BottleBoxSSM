package com.bottle.service.impl;

import com.bottle.common.Result;
import com.bottle.dao.UserDao;
import com.bottle.domain.User;
import com.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        int nums = userDao.insertUser(user);
        return nums;
    }

    @Override
    public List<User> findUsers() {
        return userDao.selectUsers();
    }

    @Override
    public Result loginUser(User user) {
        int nums = userDao.loginUser(user).size();
        if (nums>0) {
            return Result.success();
        }
        return Result.error();
    }
}
