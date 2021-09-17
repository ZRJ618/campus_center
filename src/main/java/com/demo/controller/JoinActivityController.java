package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.activity.BActivity;
import com.demo.pojo.PageResult;
import com.demo.service.JoinActivityService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/joinActivity")
public class JoinActivityController {

    @Resource
    JoinActivityService joinActivityService;


    @PutMapping("/addJoinActivity")
    @ApiOperation("参加活动")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动Id", required = true)
    })
    public ResultBody addJoinActivity(@RequestParam("activityId")String activityId,
                                      HttpServletRequest request){
        synchronized (this) {
            String userId = ParamUtil.getUserId(request);
            boolean flag = joinActivityService.addJoinActivity(userId, activityId);
            return ResultBody.ResHandle(flag, "参加活动失败");
        }
    }

    @GetMapping("/getJoinList")
    @ApiOperation("获取个人参加的所有活动列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true)
    })
    public ResultBody getJoinList(@RequestParam("pageNum")Integer pageNum,
                                              HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        PageResult<BActivity> pageResult = joinActivityService.getJoinList(userId, pageNum);
        return ResultBody.ResHandle(pageResult, "该用户未参加过活动");
    }

    @DeleteMapping("/cancelJoin")
    @ApiOperation("取消活动参加")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "activityId", value = "活动Id", required = true)
    })
    public ResultBody cancelJoin(@RequestParam("activityId")String activityId,
                                         HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        boolean flag = joinActivityService.cancelJoin(userId, activityId);
        return ResultBody.ResHandle(flag, "取消活动失败");

    }
}
