package com.bottle.service;

import com.bottle.common.Result;
import com.bottle.domain.Document;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DocService {
    Result insertDoc(MultipartFile multipartFile, HttpServletRequest request) throws IOException;
    Result listDoc(Integer userId);
    Result deleteDoc(String uuid, HttpServletRequest request);
    void downloadDoc(String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException;

}
