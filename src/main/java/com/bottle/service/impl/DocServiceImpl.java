package com.bottle.service.impl;

import com.bottle.common.Result;
import com.bottle.dao.DocDao;
import com.bottle.domain.Document;
import com.bottle.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DocServiceImpl implements DocService {
    @Autowired
    DocDao docDao;

    @Override
    public Result insertDoc(MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String realPath = request.getServletContext().getRealPath("/file");
        // 先获取到文件要保存的路径
        String fileName = multipartFile.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        File target = new File(realPath, uuid + "_" + fileName);
        // 如果存放路径不存在，就新建一个
        if (!target.getParentFile().exists()) {
            // 新建文件夹
            if (!target.getParentFile().mkdirs()) {
                return Result.error("无法新建文件夹");
            }
        }
        // 成功的话将文件保存
        multipartFile.transferTo(target);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
//        System.out.println(formatter.format(date));
        Document document = new Document(null, fileName, uuid, formatter.format(date), 1);
        docDao.insertDoc(document);
//        System.out.println(document.getName() + document.getUuid() + document.getTime() + document.getUserId());

        return Result.success();
    }

    @Override
    public Result listDoc(Integer userId) {
        List<Document> documents = docDao.listDoc(userId);
        if (documents != null) {
            return Result.success(documents);
        }
        return Result.error();
    }

    @Override
    public Result deleteDoc(String uuid, HttpServletRequest request) {
        String realPath = request.getServletContext().getRealPath("/file/");
        File folder = new File(realPath);
        String[] fileList = folder.list();
        if (fileList == null || uuid == null) {
            return Result.error("文件不存在");
        }
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].indexOf(uuid) != -1) {
                File file = new File(realPath + fileList[i]);
                Boolean deleteBool = file.delete();
                int num = docDao.deleteDoc(uuid);
                if (!deleteBool && num < 1) {
                    return Result.error("文件删除失败，数据库删除失败！");
                }
                if (deleteBool && num < 1) {
                    return Result.error("文件删除成功，数据库删除失败！");
                }
                if (!deleteBool) {
                    return Result.error("文件删除失败，数据库删除成功！");
                }
                return Result.success("文件删除成功");
            }
        }
        return Result.error("文件不存在");
    }

    @Override
    public void downloadDoc(String uuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getServletContext().getRealPath("/file/");
        File file = new File(realPath);
        String[] fileList = file.list();
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].indexOf(uuid) != -1) {

//                System.out.println(realPath + fileList[i]);
                //获取输入流
                InputStream bis = new BufferedInputStream(new FileInputStream(realPath + fileList[i]));

                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileList[i], "UTF-8"));
                response.setContentType("multipart/form-data");

                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
                int len = 0;
                while ((len = bis.read()) != -1) {
                    out.write(len);
                    out.flush();
                }
                out.close();

            } else {
                System.out.println("不存在包含关系");
            }
        }
    }

}
