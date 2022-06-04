package com.bottle.dao;

import com.bottle.domain.Blog;

import java.util.List;

public interface BlogDao {
    int insertBlog(Blog blog);
    int updateBlog(Blog blog);
    int deleteBlog(Integer id);
    Blog selectBlog(Integer id);
    List<Blog> listBlog(Integer userId);
}
