package com.bottle.dao;

import com.bottle.domain.Blog;
import com.bottle.domain.Document;

import java.util.List;

public interface DocDao {
    int insertDoc(Document doc);
    int deleteDoc(String uuid);
    List<Document> listDoc(Integer userId);
}
