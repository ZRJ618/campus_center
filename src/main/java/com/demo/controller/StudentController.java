package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.user.StudentModel;
import com.demo.service.StudentService;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {

    /*@Resource
    StudentService studentService;
    *//*获取本人个人信息*//*
    @GetMapping("/getPersonalStudent")
    @ApiOperation("获取本人个人信息")
    public ResultBody getPersonalStudent(HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        StudentModel personalStudent = studentService.getPersonalStudent(studentId);
        return ResultBody.ResHandle(personalStudent, "获取个人信息失败");
    }
    *//*添加个人信息*//*
    @PutMapping("/addStudentInfo")
    @ApiOperation("添加个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", required = true),
            @ApiImplicitParam(name = "userRealName", value = "真实姓名", dataType = "String", required = true),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "String", required = true),
            @ApiImplicitParam(name = "grade", value = "年级", dataType = "String", required = true),
            @ApiImplicitParam(name = "major", value = "专业", dataType = "String", required = true),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String", required = true),
            @ApiImplicitParam(name = "headPortrait", value = "头像", dataType = "String", required = true),
            @ApiImplicitParam(name = "inchPhoto", value = "一寸照片", dataType = "String", required = true),
    })
    public ResultBody addStudentInfo(@RequestParam("userName")String userName,
                                     @RequestParam("userRealName")String userRealName,
                                     @RequestParam("sex")String sex,
                                     @RequestParam("grade")String grade,
                                     @RequestParam("major")String major,
                                     @RequestParam("email")String email,
                                     @RequestParam("headPortrait")String headPortrait,
                                     @RequestParam("inchPhoto")String inchPhoto,
                                     HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = studentService.addStudentInfo(studentId, userName, userRealName, sex, grade, major, email, headPortrait, inchPhoto);
        return ResultBody.ResHandle(flag, "添加个人信息失败");

    }
    *//*删除个人信息*//*
    @DeleteMapping("/deleteStudentInfo")
    @ApiOperation("删除个人信息")
    public ResultBody deletedStudentInfo(HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = studentService.deletedStudentInfo(studentId);
        return ResultBody.ResHandle(flag, "删除个人信息失败");
    }

    @PostMapping("/updateStudentInfo")
    @ApiOperation("更新个人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataType = "String"),
            @ApiImplicitParam(name = "userRealName", value = "真实姓名", dataType = "String"),
            @ApiImplicitParam(name = "sex", value = "性别", dataType = "String"),
            @ApiImplicitParam(name = "grade", value = "年级", dataType = "String"),
            @ApiImplicitParam(name = "major", value = "专业", dataType = "String"),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String"),
            @ApiImplicitParam(name = "headPortrait", value = "头像", dataType = "String"),
            @ApiImplicitParam(name = "inchPhoto", value = "一寸照片", dataType = "String"),
    })
    public ResultBody updateStudentInfo(String userName,
                                        String userRealName,
                                        String sex,
                                        String grade,
                                        String major,
                                        String email,
                                        String headPortrait,
                                        String inchPhoto,
                                        HttpServletRequest request){
        String studentId = ParamUtil.getUserId(request);
        boolean flag = studentService.updateStudentInfo(studentId, userName, userRealName, sex, grade, major, email, headPortrait, inchPhoto);
        return ResultBody.ResHandle(flag, "更新个人信息失败");

    }*/

}
