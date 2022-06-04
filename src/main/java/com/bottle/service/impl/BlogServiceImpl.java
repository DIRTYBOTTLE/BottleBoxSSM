package com.bottle.service.impl;

import com.bottle.common.Result;
import com.bottle.dao.BlogDao;
import com.bottle.domain.Blog;
import com.bottle.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;

    @Override
    public Result insertBlog(Blog blog) {
        int num = blogDao.insertBlog(blog);
        if (num > 0) {
            System.out.println(blog.getId());
            return Result.success(blog.getId());
        }
        return Result.error();
    }

    @Override
    public Result updateBlog(Blog blog) {
        int num = blogDao.updateBlog(blog);
        if (num > 0) {
            return Result.success();
        }
        return Result.error();
    }

    @Override
    public Result deleteBlog(Integer id) {
        int num = blogDao.deleteBlog(id);
        if (num > 0) {
            return Result.success();
        }
        return Result.error();
    }

    @Override
    public Result selectBlog(Integer id) {
        Blog blog = blogDao.selectBlog(id);
        if (blog != null) {
            return Result.success(blog);
        }
        return Result.error();
    }

    @Override
    public Result listBlog(Integer userId) {
        List<Blog> blogs = blogDao.listBlog(userId);
        return Result.success(blogs);
    }
}
