package com.llt.recruit.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class UploadController {


    @RequestMapping("userAvatar")
    public void userAvatar(HttpServletRequest request, HttpServletResponse response) throws Exception {


        MultipartHttpServletRequest  mutliRequest = (MultipartHttpServletRequest) request;
        //1.获取图片数据
        MultipartFile mfile = mutliRequest.getFile("userAvatar");


        //2.把图片保存在某个路径

        //2.1文件保存的文件夹路径
        String uploadFolder = request.getServletContext().getRealPath("/upload");
        System.out.println(uploadFolder);
        File uploadFolderFile = new File(uploadFolder);
        if(!uploadFolderFile.exists()){
            uploadFolderFile.mkdir();
        }

        //2.2.文件
        String suffix = mfile.getOriginalFilename().split("\\.")[1];
        String fileName = UUID.randomUUID().toString().replace("-","") + "." + suffix;
        String totalPath = uploadFolder + "\\" + fileName;
        System.out.println("totalpath:" + totalPath);
        FileCopyUtils.copy(mfile.getInputStream(),new FileOutputStream(new File(totalPath)));

        //返回数据给客户端
        String imgURL = "http://localhost:8080/upload/" + fileName;
        String responseJson = "{\"imgUrl\":\"" + imgURL  + "\"}";
        response.setHeader("content-type","text/json;charset=utf-8");
        response.getWriter().write(responseJson);

    }
}