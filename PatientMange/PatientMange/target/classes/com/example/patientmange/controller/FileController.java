package com.example.patientmange.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Tag(name = "文件管理")
@RestController
@Slf4j
public class FileController {
    private static final String UPLOADED_FOLDER = System.getProperty("user.dir")+"upload";
    @Operation(summary = "文件上传")
    @PostMapping(path="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //HttpServletRequest：request请求对象（web服务器）
    public String upload(String nickname, @RequestPart("file")MultipartFile f, HttpServletRequest request) throws IOException{
        System.out.println(nickname);
        System.out.println("文件大小："+f.getSize());
        //文件类型
        System.out.println(f.getContentType());
        //文件原始名称
        System.out.println(f.getOriginalFilename());

        System.out.println(System.getProperty("user.dir"));
        //上传云端后获取文件路径
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        //保存文件
        saveFile(f,path);
        return "上传成功";
    }

    public void saveFile(MultipartFile f,String path) throws IOException{
        File upDir = new File(path);
        //如果目录不存在就创建
        if(!upDir.exists()){
            //创建目录
            upDir.mkdir();
        }
        File file = new File(path+f.getOriginalFilename());
        f.transferTo(file);
    }
}
