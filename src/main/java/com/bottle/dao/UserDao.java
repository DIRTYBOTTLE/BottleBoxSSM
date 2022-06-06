package com.bottle.dao;

import com.bottle.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    User selectUser(@Param("name") String name, @Param("password") String password);

    int insertUser(User user);

    List<User> selectUsers();
}
