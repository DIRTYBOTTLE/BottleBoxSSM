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
    public Result<?> login(User user) {
        User selectUser = userDao.selectUser(user.getName(), user.getPassword());
        if (selectUser != null) {
            return Result.success(selectUser);
        }
        return Result.error();
    }


    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public List<User> findUsers() {
        return userDao.selectUsers();
    }


}
