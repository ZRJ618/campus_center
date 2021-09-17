package com.demo.util;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.UUID;

/*
* 上传图片存放到static文件夹下并返回一个URI/URL
* */
public class UploadImage {

    /*
    * 返回图片的URI
    * multipartFile: 接收image文件
    * uri: 存储image的相对地址，例:【“/selfImage/”】，注意前后都要有“/”,例，在前端访问静态资源时，请求地址为:http://localhost:8080/selfImage/79789798.jpg
    * */
    public static String uploacImage(MultipartFile multipartFile, String uri) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //项目的classes的绝对路径
        String classesPath = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(),"utf-8");
        String newFileName = UUID.randomUUID().toString();
        File file = new File(classesPath+uri+newFileName+fileType);
        if(!file.exists()){
            file.mkdirs();
        }
        multipartFile.transferTo(file);
        //返回该图片的URI
        return uri+newFileName+fileType;
    }
    /*
    * 返回图片的URL（协议+ip+端口+uri）
    * */
    public static String uploacImage(MultipartFile multipartFile, String uri, HttpServletRequest request) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //项目的classes的绝对路径
        String classesPath = URLDecoder.decode(ClassUtils.getDefaultClassLoader().getResource("").getPath(),"utf-8");
        String newFileName = UUID.randomUUID().toString();
        File file = new File(classesPath+uri+newFileName+fileType);
        if(!file.exists()){
            file.mkdirs();
        }
        multipartFile.transferTo(file);
        //请求的URI
        String requestURI = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
        //图片的URI
        String imageURI = uri+newFileName+fileType;
        //返回图片的URL
        return requestURI+imageURI;
    }

}
