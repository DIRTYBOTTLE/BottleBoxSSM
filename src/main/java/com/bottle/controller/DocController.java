package com.bottle.controller;

import com.bottle.common.Result;
import com.bottle.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/doc")
public class DocController {

    @Autowired
    private DocService docService;

    @RequestMapping("/upload.do")
    @ResponseBody
    public Result upload(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        return docService.insertDoc(multipartFile, request);
    }

    @RequestMapping("/download.do")
    public void download(String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        docService.downloadDoc(uuid, request, response);
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public Result list(@RequestParam Integer userId) {
        return docService.listDoc(1);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public Result delete(String uuid, HttpServletRequest request) {
        return docService.deleteDoc(uuid, request);
//        return Result.success(uuid);
    }

}
