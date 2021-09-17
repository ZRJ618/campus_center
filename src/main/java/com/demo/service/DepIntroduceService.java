package com.demo.service;


import com.demo.pojo.introduce.DepIntroduceModel;
import com.demo.pojo.introduce.DepIntroducePojo;

public interface DepIntroduceService {
    boolean addDepIntroduce(String departmentName, String briefIntroduce, String workIntroduce, String recruit,
                            String depImage, String chargeOne, String chargeTow, String chargeThree);

    boolean updateCharge(String departmentName, String chargeOne, String chargeType);

    boolean updateDepIntroduce(String departmentName, String briefIntroduce, String workIntroduce,
                               String recruit, String depImage);

    DepIntroduceModel showDepInfo(String departmentName);

    boolean deleteDepInfo(String departmentName);
}
