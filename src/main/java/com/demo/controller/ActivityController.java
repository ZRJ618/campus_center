package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.*;
import com.demo.pojo.activity.BActivity;
import com.demo.pojo.activity.DetailActivity;
import com.demo.service.ActivityService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/activity")
public class ActivityController {


    @Resource
    ActivityService activityService;
    @PutMapping("/addActivity")
    @ApiOperation("添加活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityTitle", value = "活动标题", required = true),
            @ApiImplicitParam(name = "activityContent", value = "活动内容", required = true),
            @ApiImplicitParam(name = "activityImage", value = "活动图片", required = true),
            @ApiImplicitParam(name = "activityStartTime", value = "活动开始时间", required = true),
            @ApiImplicitParam(name = "activityEndTime", value = "活动结束时间", required = true),
            @ApiImplicitParam(name = "activityObject", value = "招募面向对象", required = true),
            @ApiImplicitParam(name = "recruitStartTime", value = "招募开始时间", required = true),
            @ApiImplicitParam(name = "recruitEndTime", value = "招募结束时间", required = true),
            @ApiImplicitParam(name = "totalNum", value = "总招募人数", required = true),
            @ApiImplicitParam(name = "activityPlace", value = "活动地点", required = true),
    })
    public ResultBody addActivity(@RequestParam("activityTitle")String activityTitle,
                                  @RequestParam("activityContent")String activityContent,
                                  @RequestParam("activityImage")String activityImage,
                                  @RequestParam("activityStartTime")String activityStartTime,
                                  @RequestParam("activityEndTime")String activityEndTime,
                                  @RequestParam("activityObject") String activityObject,
                                  @RequestParam("recruitStartTime")String recruitStartTime,
                                  @RequestParam("recruitEndTime")String recruitEndTime,
                                  @RequestParam("totalNum")Integer totalNum,
                                  @RequestParam("activityPlace")String activityPlace,
                                  @RequestParam("activityAddress")String activityAddress,
                                  @RequestParam("activityType")String activityType,
                                  HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        boolean flag = activityService.addActivity(activityTitle, activityContent, activityImage, activityStartTime,
                activityEndTime, activityObject, recruitStartTime, recruitEndTime, totalNum, 0,
                userId, activityPlace, activityAddress, activityType);
            return ResultBody.ResHandle(flag, "添加活动失败");

    }
    @PostMapping("/updateActivity")
    @ApiOperation("修改活动信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true),
            @ApiImplicitParam(name = "activityTitle", value = "活动标题") ,
            @ApiImplicitParam(name = "activityContent", value = "活动内容"),
            @ApiImplicitParam(name = "activityStartTime", value = "活动开始时间"),
            @ApiImplicitParam(name = "activityEndTime", value = "活动结束时间"),
            @ApiImplicitParam(name = "activityObject", value = "招募面向对象"),
            @ApiImplicitParam(name = "recruitStartTime", value = "招募开始时间"),
            @ApiImplicitParam(name = "recruitEndTime", value = "招募结束时间"),
            @ApiImplicitParam(name = "totalNum", value = "总招募人数"),
            @ApiImplicitParam(name = "joinNum", value = "参加人数"),
            @ApiImplicitParam(name = "activityPlace", value = "活动地点"),
    })
    public ResultBody updateActivity(
                                     @RequestParam("activityId")String activityId,
                                     String activityTitle,
                                     String activityContent,
                                     String activityStartTime,
                                     String activityEndTime,
                                     String activityObject,
                                     String recruitStartTime,
                                     String recruitEndTime,
                                     Integer totalNum,
                                     Integer joinNum,
                                     String activityPlace,
                                     String activityAddress,
                                     String activityType
    ){
        boolean flag = activityService.updateActivity(activityId, activityTitle, activityContent, activityStartTime, activityEndTime,
                activityObject, recruitStartTime, recruitEndTime, totalNum, joinNum, activityPlace, activityAddress, activityType);
        return ResultBody.ResHandle(flag, "更新活动内容");

    }
    /*通过个人学号 查询该用户发布的活动*/
    @GetMapping("/getReleaseActivityById")
    @ApiOperation("通过userId 查询该用户发布的活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学号", required = true),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true)
    })
    public ResultBody getReleaseActivityById(@RequestParam("pageNum")Integer pageNum,
                                             HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        PageResult activityPersonalList = activityService.getActivityPersonalList(userId, pageNum);
        return ResultBody.ResHandle(activityPersonalList, "该用户未发布活动");
    }

    @GetMapping("/getActivityList")
    @ApiOperation("条件查询活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true),
            @ApiImplicitParam(name = "activityObject", value = "招募对象"),
            @ApiImplicitParam(name = "activityStatus", value = "状态"),
            @ApiImplicitParam(name = "activityPlace", value = "活动地点"),
    })
    public ResultBody getActivityList( String activityTitle,
                                             String activityObject,
                                             String activityStatus,
                                             String activityPlace,
                                             @RequestParam("pageNum")Integer pageNum
                                             ){

        PageResult<BActivity> pageResult = activityService.getActivityList(activityTitle,
                activityObject, activityStatus, activityPlace, pageNum);

        return ResultBody.ResHandle(pageResult, "未查询到内容");
    }
    @GetMapping("/getDetailActivity")
    @ApiOperation("查询详细活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true),
    })
    public ResultBody getDetailActivity(@RequestParam("activityId")String activityId,
                                        HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        DetailActivity detailActivity = activityService.getDetailActivity(activityId, userId);
        return ResultBody.ResHandle(detailActivity, "未查询到详细活动");
    }

    @DeleteMapping("/deleteActivity")
    @ApiOperation("删除活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动id", required = true),
    })
    public ResultBody deleteActivity(@RequestParam("activityId")String activityId){
        boolean flag = activityService.deletedActivity(activityId);
        return ResultBody.ResHandle(flag, "删除活动失败");
    }

}
