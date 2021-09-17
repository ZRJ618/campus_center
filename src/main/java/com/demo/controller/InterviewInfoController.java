package com.demo.controller;

import com.demo.exception.GlobalException;
import com.demo.exception.ResultBody;
import com.demo.pojo.interview.InterviewInfo;
import com.demo.pojo.interview.InterviewInfoModel;
import com.demo.pojo.PageResult;
import com.demo.service.InterviewInfoService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/interviewInfo")
public class InterviewInfoController {

    @Resource
    InterviewInfoService interviewInfoService;
    /*
    * 添加面试信息
    * */
    @PostMapping("/addInterviewInfo")
    @ApiOperation("添加面试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true),
            @ApiImplicitParam(name="rank", value="志愿优先级", dataType="Integer", required=true),
            @ApiImplicitParam(name="know", value="对部门的认识", dataType="String", required=true),
            @ApiImplicitParam(name = "advantage", value = "个人优点", dataType = "String", required = true),
            @ApiImplicitParam(name = "disadvantage", value = "个人缺点", dataType = "String", required = true)
    })
    public ResultBody addInterviewInfo(@RequestParam("departmentName")String departmentName,
                                       @RequestParam("rank")Integer rank,
                                       @RequestParam("know")String know,
                                       @RequestParam("advantage")String advantage,
                                       @RequestParam("disadvantage")String disadvantage,
                                       HttpServletRequest request){
        InterviewInfo interviewInfo = new InterviewInfo();
        interviewInfo.setKnow(know);
        interviewInfo.setRank(rank);
        interviewInfo.setAdvantage(advantage);
        interviewInfo.setDisadvantage(disadvantage);
        String userId = ParamUtil.getUserId(request);
        interviewInfo.setUserId(userId);
        boolean flag = interviewInfoService.addInterviewInfo(interviewInfo, departmentName);
        return ResultBody.ResHandle(flag, "添加信息失败");

    }
    /*
    * 修改面试信息*/
    @PutMapping("/updateInterviewInfo")
    @ApiOperation("修改面试信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true),
            @ApiImplicitParam(name="rank", value="志愿优先级", dataType="Integer"),
            @ApiImplicitParam(name="know", value="对部门的认识", dataType="String"),
            @ApiImplicitParam(name = "advantage", value = "个人优点", dataType = "String"),
            @ApiImplicitParam(name = "disadvantage", value = "个人缺点", dataType = "String")
    })
    public ResultBody updateInterviewInfo(@RequestParam("departmentName")String departmentName,
                                       Integer rank,
                                       String know,
                                       String advantage,
                                       String disAdvantage,
                                       HttpServletRequest request){
        if(departmentName == null){
            throw new GlobalException("500", "部门名不能为空");
        }
        String userId = ParamUtil.getUserId(request);
        boolean flag = interviewInfoService.updateInterviewInfo(userId, departmentName, rank, know, advantage, disAdvantage);
        return ResultBody.ResHandle(flag, "添加父级部门失败");
    }
    /*
    * 获取面试单信息*/
    @GetMapping("/getPersonalInterviewInfo")
    @ApiOperation("获取面试单信息")
    public ResultBody getPersonalInterviewInfo(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        List<InterviewInfoModel> interviewInfo = interviewInfoService.getPersonalInterviewInfo(userId);
        return ResultBody.ResHandle(interviewInfo, "未查询到面试单信息");
    }
    /*获取一个部门的面试单信息*/
    @GetMapping("/getDepartmentInterviewInfo")
    @ApiOperation("获取一个部门的面试单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true),
            @ApiImplicitParam(name="pageNum", value="当前页", dataType="Integer", required = true),
    })
    public ResultBody getDepartmentInterviewInfo(@RequestParam("departmentName")String departmentName,
                                                 @RequestParam("pageNum")Integer pageNum){
        PageResult<InterviewInfoModel> departmentInterviewInfo = interviewInfoService.getDepartmentInterviewInfo(departmentName, pageNum);
        return ResultBody.ResHandle(departmentInterviewInfo, "未查询到部门面试单列表");
    }
    /*删除面试单信息*/
    @DeleteMapping("/deleteInterviewInfo")
    @ApiOperation("删除面试单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="departmentName", value="部门名字", dataType="String", required=true)
    })
    public ResultBody deleteInterviewInfo(@RequestParam("departmentName")String departmentName,
                                          HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = interviewInfoService.deleteInterviewInfo(departmentName, studentId);
        return ResultBody.ResHandle(flag, "删除面试单信息失败");
    }

}
