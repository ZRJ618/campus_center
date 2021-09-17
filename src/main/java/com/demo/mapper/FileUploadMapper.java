package com.demo.mapper;

import com.demo.pojo.ImagePath;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Mapper
@Repository
public interface FileUploadMapper {
    void uploadImagePath(ImagePath imagePath);

    String imageDownload(String id, String imageType);
}
