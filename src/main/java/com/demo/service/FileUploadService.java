package com.demo.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileUploadService {
    String imageUpload(MultipartFile file, String type, HttpServletRequest request) throws Exception;
    void imageDownload(String id, String imageType, HttpServletResponse response);
}
