package com.demo.pojo.introduce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* *
 * @description: 部门风采展示表(对应数据库)

 * @author: lazy
 * @dateTime: 2021/3/20 15:56
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepIntroducePojo {
    //部门id
    private String departmentId;
    //部门简介
    private String briefIntroduce;
    //工作介绍
    private String workIntroduce;
    //招募要求
    private String recruit;
    //部门照片
    private String depImage;
    //主要负责人
    private String chargeOne;
    //次要负责人
    private String chargeTwo;
    //次要负责人
    private String chargeThree;
    //创建时间
    private String createTime;
    //修改时间
    public String modifyTime;
}
