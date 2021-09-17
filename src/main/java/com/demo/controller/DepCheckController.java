package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.PageResult;
import com.demo.pojo.department.DepCheck;
import com.demo.service.DepCheckService;
import com.demo.util.ParamUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/depCheck")
public class DepCheckController {

    @Resource
    DepCheckService depCheckService;

    /* *
     * @description: 添加部门认证
     * @params: [request, realName 用户真实姓名, grade, imagePath, departmentId]
     * @return: com.demo.exception.ResultBody
     * @author: lazy
     * @dateTime: 2021/4/6 21:12
     */
    @PutMapping("/addDepCheck")
    public ResultBody addDepCheck(HttpServletRequest request,
                                  @RequestParam("realName")String realName,
                                  @RequestParam("grade")String grade,
                                  @RequestParam("imagePath")String imagePath,
                                  @RequestParam("departmentId")String departmentId
                                  ) {
        String userId = ParamUtil.getUserId(request);
        boolean flag = depCheckService.addDepCheck(userId, realName, grade, imagePath, departmentId);
        return ResultBody.ResHandle(flag, "添加失败");
    }

    @GetMapping("/getDepCheckList")
    public ResultBody getDepCheck(@RequestParam("pageNum")Integer pageNum,
                                  String studentId,
                                  String departmentName,
                                  boolean checkStatus) {
        PageResult<DepCheck> depCheckList = depCheckService.getDepCheckList(studentId, departmentName, checkStatus, pageNum);
        return ResultBody.ResHandle(depCheckList, "未查询到信息");
    }

    @GetMapping("setDepCheck")
    public ResultBody setDepCheck(@RequestParam("depCheckId")String depCheckId,
                                  @RequestParam("checkStatus")String checkStatus) {
        boolean flag = depCheckService.setDepCheck(depCheckId, checkStatus);
        return ResultBody.ResHandle(flag, "审批提交失败");
    }
}
