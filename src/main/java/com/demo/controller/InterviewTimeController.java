package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.interview.InterviewTimeModel;
import com.demo.service.InterviewTimeService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/interviewTime")
public class InterviewTimeController {

    @Resource
    InterviewTimeService interviewTimeService;

    @ApiOperation("添加面试时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentName", value = "部门名", dataType = "String", required = true),
            @ApiImplicitParam(name = "startTime", value = "面试开始时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "endTime", value = "面试结束时间", dataType = "String", required = true)
    })
    @PutMapping("/addInterviewTimeInfo")
    public ResultBody addInterviewTimeInfo(@RequestParam("departmentName")String departmentName,
                                           @RequestParam("startTime")String startTime,
                                           @RequestParam("endTime")String endTime,
                                           HttpServletRequest request
                                           ){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = interviewTimeService.addInterviewTimeInfo(studentId, departmentName, startTime, endTime);
        return ResultBody.ResHandle(flag, "添加面试时间失败");
    }
    /*
    * 获取个人面试单列表*/
    @GetMapping("/getInterviewTimeInfo")
    @ApiOperation("获取个人面试单列表")
    public ResultBody getInterviewTimeInfo(HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        InterviewTimeModel interviewInfo = interviewTimeService.getInterviewInfo(studentId);
        return ResultBody.ResHandle(interviewInfo, "获取个人面试单列表失败");
    }

    /*删除面试时间安排*/
    @DeleteMapping("/deletedInterviewTimeInfo")
    @ApiOperation("删除面试时间安排")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentName", value = "部门名", dataType = "String", required = true)
    })
    public ResultBody deletedInterviewTimeInfo(@RequestParam("departmentName")String departmentName,
                                               HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = interviewTimeService.deleteInterviewInfo(studentId, departmentName);
        return ResultBody.ResHandle(flag, "删除面试时间安排失败");
    }

    @PostMapping("updateInterviewTimeInfo")
    @ApiOperation("修改面试时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "timeId", value = "面试时间id", dataType = "String", required = true),
            @ApiImplicitParam(name = "departmentName", value = "部门名", dataType = "String", required = true),
            @ApiImplicitParam(name = "startTime", value = "面试开始时间", dataType = "String", required = true),
            @ApiImplicitParam(name = "endTime", value = "面试结束时间", dataType = "String", required = true)
    })
    public ResultBody updateInterviewTimeInfo(@RequestParam("timeId")String timeId,
                                              String departmentName,
                                              String startTime,
                                              String endTime){
        boolean flag = interviewTimeService.updateInterviewTime(timeId, departmentName, startTime, endTime);
        return ResultBody.ResHandle(flag, "修改面试时间失败");
    }
}
