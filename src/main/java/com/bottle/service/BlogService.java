package com.bottle.service;

import com.bottle.common.Result;
import com.bottle.domain.Blog;

public interface BlogService {
    Result insertBlog(Blog blog);
    Result updateBlog(Blog blog);
    Result deleteBlog(Integer id);
    Result selectBlog(Integer id);
    Result listBlog(Integer userId);
}
