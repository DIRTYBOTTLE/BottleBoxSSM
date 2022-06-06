package com.bottle.controller;

import com.bottle.common.Result;
import com.bottle.domain.User;
import com.bottle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Result<?> login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping("/registerUser.do")
    public ModelAndView addUser(@RequestBody User user) {
        ModelAndView mv = new ModelAndView();
        String tips = "注册成功";
        //调用service处理user
        int nums = userService.addUser(user);
        if (nums > 0) {
            //注册成功
            tips = "用户" + user.getName() + "注册成功";
        }
        //添加数据
        mv.addObject("tips", tips);
        //指定结果页面
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryUser.do")
    @ResponseBody
    public List<User> queryUser() {
        return userService.findUsers();
    }


}
