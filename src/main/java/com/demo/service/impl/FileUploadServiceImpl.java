package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.FileUploadMapper;
import com.demo.pojo.ImagePath;
import com.demo.service.FileUploadService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Resource
    FileUploadMapper fileUploadMapper;

    public String imageUpload(MultipartFile file, String type, HttpServletRequest request) {
        if(file == null) {
            throw new GlobalException("500", "未选择需要上传的图片");
        }
        String path = "src/main/resources/static/image/" + type + "/";
        String filePath = new File(path).getAbsolutePath();
        File fileUpload = new File(filePath);

        //未创建目录则创建目录
        if(fileUpload.exists()) {
            fileUpload.mkdirs();
        }
        //获取文件名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString().replace("-", "") + oldName.substring(oldName.lastIndexOf("."));
        fileUpload = new File(filePath, newName);
        try {
            //上传文件到fileUpload目录
            file.transferTo(fileUpload);
        }catch (IOException e) {
            e.printStackTrace();
        }
        String resultPath = request.getScheme() + "://" + request.getServerName() +
                ":" + request.getServerPort() + request.getContextPath() + "/" +
                "image/" + type + newName;
        return resultPath;
    }


    /*图片上传*//*
    public void imageUpload(MultipartFile file, String type, String userId) throws Exception{
        //判断图片是否为空
        if(file == null){
            throw new GlobalException("500", "未选择需要上传的图片");
        }
        //设置图片路径
        String path = "src/main/resources/static/image/" + type;
        if("activity".equals(type)){
            //path = path + "/" + UUID.randomUUID().toString().replace("-", "");
        }
        //获取文件的绝对路径
        String filePath = new File( path).getAbsolutePath();
        File fileUpload = new File(filePath);

        //若目录不存在，则创建目录
        if(!fileUpload.exists()){
            fileUpload.mkdirs();
        }
        //getOriginalFilename()获取上传文件的文件名
        String oldName = file.getOriginalFilename();
        System.out.println(oldName);
        System.out.println(oldName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString().replace("-", "") + oldName.substring(oldName.lastIndexOf("."));
        fileUpload = new File(filePath, newName);
        //查看文件是否存在
        if(fileUpload.exists()){
            throw new Exception("上传文件已存在");
        }
        try{
            //将文件上传到服务器指定文件
            file.transferTo(fileUpload);
            ImagePath imagePath = new ImagePath();
            imagePath.setImageId(UUID.randomUUID().toString().replace("-", ""));
            imagePath.setStudentId(userId);
            imagePath.setPath(fileUpload.getPath());
            imagePath.setImageType(type);
            imagePath.setCreateTime(DateUtils.getDate());
            imagePath.setModifyTime(DateUtils.getDate());
            fileUploadMapper.uploadImagePath(imagePath);
            return ;
        }catch(IOException e){
            throw new Exception("上传图片到服务器失败" + e.toString());
        }
    }*/

    /* *
     * @description: 图片下载
     * @params: [id, imageType, response]
     * @return: void
     * @author: lazy
     * @dateTime: 2021/3/22 20:31
     */
    @Override
    public void imageDownload(String id, String imageType, HttpServletResponse response) {
        String path = fileUploadMapper.imageDownload(id, imageType);
        String imageName = path.substring(path.lastIndexOf("\\")+1, path.length());
        //System.out.println(imageName);

        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition",
                "attachment;fileName=" + imageName);
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while(i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bis != null) {
                    bis.close();
                }
                if(fis != null) {
                    fis.close();
                }
                if(os != null) {

                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void test(HttpServletRequest request) {

        System.out.println(request.getScheme() + "://" + request.getServerName() +
                ":" + request.getServerPort() + request.getContextPath() + "/" +
                "image/" + "activity/" + "13919d71360247599f92ff117a1bf518.jpg");
    }


}
