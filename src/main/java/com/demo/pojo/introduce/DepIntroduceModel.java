package com.demo.pojo.introduce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepIntroduceModel {
    //部门名
    private String departmentName;
    //部门简介
    private String briefIntroduce;
    //工作介绍
    private String workIntroduce;
    //招募要求
    private String recruit;
    //负责人信息
    private List<ChargeMan> chargeManList;

}
