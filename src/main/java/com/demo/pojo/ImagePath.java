package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/* *
 * @description: 图片类(对应数据库)
 * @author: lazy
 * @dateTime: 2021/3/20 15:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImagePath {
    //图片id
    private String imageId;
    //图片类型
    private String imageType;
    //学号
    private String studentId;
    //图片路径
    private String path;
    //创建时间
    private String createTime;
    //修改时间
    private String modifyTime;
}
