package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.service.impl.FileUploadServiceImpl;
import com.demo.util.ImageUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource
    FileUploadServiceImpl imageService;

    /* *
     * @description: 单张图片上传
     * @params: [request, type]
     * @return: java.lang.String
     * @author: lazy
     * @dateTime: 2021/4/5 16:01
     */
    @PostMapping("/uploadImageSingle")
    public ResultBody uploadImageSingle(HttpServletRequest request,
                                        @RequestParam("type")String type) throws Exception {
        MultipartFile multipartFile = ((MultipartHttpServletRequest)request).getFile("file");
        String path = imageService.imageUpload(multipartFile, type, request);
        return ResultBody.success(path);
    }

    /* *
     * @description: 多张图片上传
     * @params: [request, type]
     * @return: java.lang.String
     * @author: lazy
     * @dateTime: 2021/4/5 16:01
     */
    @PostMapping("/uploadImages")
    public ResultBody uploadImages(HttpServletRequest request,
                              @RequestParam("type")String type) throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        List<String> paths = new ArrayList<>();
        for(MultipartFile file: files) {
            String path = imageService.imageUpload(file, type, request);
            paths.add(path);

        }
        String path = ImageUtils.ListToString(paths);
        return ResultBody.success(path);
    }

    @GetMapping("/imageDownload")
    public void imageDownload(@RequestParam("id")String id,
                                    @RequestParam("imageType") String imageType,
                                    HttpServletResponse response) {
        imageService.imageDownload(id, imageType, response);
    }

    @GetMapping("/test")
    public void test(HttpServletRequest request) {
        imageService.test(request);
    }
}
