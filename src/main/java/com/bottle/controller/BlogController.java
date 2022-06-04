package com.bottle.controller;

import com.bottle.common.Result;
import com.bottle.domain.Blog;
import com.bottle.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/insert.do")
    @ResponseBody
    public Result insert(@RequestBody Blog blog) {
        return blogService.insertBlog(blog);
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public Result update(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public Result delete(@RequestParam Integer id) {
        return blogService.deleteBlog(id);
    }

    @RequestMapping("/select.do")
    @ResponseBody
    public Result select(@RequestParam Integer id) {
        return blogService.selectBlog(id);
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public Result list(@RequestParam Integer userId) {
        return blogService.listBlog(userId);
    }

}
