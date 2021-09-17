package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.PageResult;
import com.demo.pojo.leaveApply.LeaveApplyModel;
import com.demo.service.LeaveApplyService;
import com.demo.util.ParamUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/leaveApply")
public class LeaveApplyController {

    @Resource
    LeaveApplyService leaveApplyService;

    @PostMapping("/addApply")
    public ResultBody addApply(@RequestParam("leaveType")String leaveType,
                               @RequestParam("startTime")String startTime,
                               @RequestParam("endTime")String endTime,
                               @RequestParam("reason")String reason,
                               @RequestParam("applyUser")String applyUser,
                               String departmentId,
                               HttpServletRequest request
                               ) {
        String userId = ParamUtil.getUserId(request);
        boolean flag = leaveApplyService.addApply(userId, leaveType, startTime, endTime, reason, departmentId, applyUser);
        return ResultBody.ResHandle(flag, "审批失败，请重新审批");
    }


    @PostMapping("/setApply")
    public ResultBody setApply(@RequestParam("applyId")String applyId,
                               Integer status,
                               String leaveType,
                               String startTime,
                               String endTime,
                               String reason,
                               String applyUser) {
        boolean flag = leaveApplyService.updateApply(applyId, status, leaveType, startTime, endTime, reason, applyUser);
        return ResultBody.ResHandle(flag, "修改信息失败");
    }

    @DeleteMapping("/deleteApply")
    public ResultBody deleteApply(@RequestParam("applyId")String applyId) {
        boolean flag = leaveApplyService.deleteApply(applyId);
        return ResultBody.ResHandle(flag, "删除失败");
    }

    @GetMapping("/getApplyList")
    public ResultBody getApplyList(@RequestParam("pageNum")Integer pageNum,
                                   String leaveType,
                                   Integer applyStatus,
                                   String userId) {
        PageResult<LeaveApplyModel> applyList = leaveApplyService.getApplyList(leaveType, applyStatus, userId, pageNum);
        return ResultBody.ResHandle(applyList, "数据为空");
    }

}
