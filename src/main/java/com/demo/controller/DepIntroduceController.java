package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.introduce.DepIntroduceModel;
import com.demo.service.DepIntroduceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/depIntroduce")
public class DepIntroduceController {

    @Resource
    DepIntroduceService depIntroduceService;

    /* *
     * @description: 添加部门简介信息
     * @params: [departmentName 部门名称, briefIntroduce 部门简介,
     * workIntroduce 工作介绍, recruit 招募要求, chargeOne 主要负责人,’
     *  chargeTow 次要负责人1, chargeThree 次要负责人2]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/3/22 16:14
     */
    @PostMapping("/addDepIntroduce")
    public ResultBody addDepIntroduce(@RequestParam("departmentName")String departmentName,
                                      @RequestParam("briefIntroduce") String briefIntroduce,
                                      @RequestParam("workIntroduce") String workIntroduce,
                                      @RequestParam("recruit") String recruit,
                                      String depImage,
                                      String chargeOne,
                                      String chargeTwo,
                                      String chargeThree
                                      ) {
        boolean flag = depIntroduceService.addDepIntroduce(departmentName, briefIntroduce, workIntroduce,
                recruit, depImage, chargeOne, chargeTwo, chargeThree);
        return ResultBody.ResHandle(flag, "添加部门介绍失败");
    }


    /* *
     * @description: 修改负责人id
     * @params: [departmentName 部门名, chargeId 负责人id, chargeType 负责人类型]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/3/22 16:18
     */
    @PostMapping("/updateCharge")
    public ResultBody updateCharge(@RequestParam("departmentName")String departmentName,
                                      @RequestParam("chargeId")String chargeId,
                                      @RequestParam("chargeType")String chargeType) {
        boolean flag = depIntroduceService.updateCharge(departmentName, chargeId, chargeType);
        return ResultBody.ResHandle(flag, "更新负责人信息失败");
    }

    /* *
     * @description: 修改部门简介信息
     * @params: [departmentName 部门名, briefIntroduce 部门简介, workIntroduce 工作介绍, recruit 招募要求]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/3/22 16:41
     */
    @PostMapping("/updateDepIntroduce")
    public ResultBody updateDepIntroduce(@RequestParam("departmentName")String departmentName,
                                         String briefIntroduce,
                                         String workIntroduce,
                                         String recruit,
                                         String depImage) {
        boolean flag = depIntroduceService.updateDepIntroduce(departmentName, briefIntroduce, workIntroduce, recruit, depImage);
        return ResultBody.ResHandle(flag, "更新部门信息失败");


    }


    /* *
     * @description: 显示部门介绍内容
     * @params: [departmentName]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/3/22 19:33
     */
    @GetMapping("/showDepInfo")
    public ResultBody showDepInfo(@RequestParam("departmentName") String departmentName) {
        DepIntroduceModel depIntroduceModel = depIntroduceService.showDepInfo(departmentName);
        return ResultBody.ResHandle(depIntroduceModel, "该部门未填写信息");
    }

    @DeleteMapping("/deleteDepInfo")
    public ResultBody deleteDepInfo(@RequestParam("departmentName")String departmentName) {
        boolean flag = depIntroduceService.deleteDepInfo(departmentName);
        return ResultBody.ResHandle(flag, "删除部门信息失败");

    }

}
