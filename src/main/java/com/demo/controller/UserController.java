package com.demo.controller;

import com.demo.config.JwtConfig;
import com.demo.exception.GlobalException;
import com.demo.exception.ResultBody;
import com.demo.mapper.UserMapper;
import com.demo.pojo.user.UserModel;
import com.demo.service.UserService;
import com.demo.util.Coder;
import com.demo.util.EmailUtils;
import com.demo.util.ParamUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;
    @Resource
    JwtConfig jwtConfig;
    @Autowired
    UserMapper userMapper;

    /*
    * 登录
    * 参数：
    *   stuId：账号
    *   password：密码
    * */
/*
    @OperateLog
    @ApiOperation("登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "studentId", value = "学号", dataType = "String", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true),
            @ApiImplicitParam(name = "check", value = "验证码", dataType = "String", required = true),
            @ApiImplicitParam(name = "confirmCheck", value = "正确验证码", dataType = "String", required = true)
    })*/
    @GetMapping("/login")
    public ResultBody login(@RequestParam("studentId")String studentId,
                            @RequestParam("password")String password,
                            @RequestParam("check")String check,
                            @RequestParam("confirmCheck")String confirmCheck) throws Exception {
        //密码加密
        if(!confirmCheck.equalsIgnoreCase(check)){
            throw new GlobalException("500", "验证码错误");
        }
        password = Coder.encryptBASE64(password);
        System.out.println(password);
        UserModel login = userService.login(studentId, password);
        if(login == null){
            return ResultBody.error("500", "登录失败");
        }else if(login.getStatus() == 0){
            return ResultBody.ResHandle(null, "该账户未激活或已注销");
        }else{
            String token = jwtConfig.createToken(login.getUserId());
            if(token == null){
                return ResultBody.error("500", "token生成失败");
            }
            login.setToken(token);
            return ResultBody.ResHandle(login, "登录成功");
        }
    }


    /*密码修改
    * 参数：
    *   旧密码
    *   新密码*/
    @PutMapping("/updatePassword")
    @ApiOperation("修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oldPassword", value = "旧密码", dataType = "String", required = true),
            @ApiImplicitParam(name = "newPassword", value = "新密码", dataType = "String", required = true),
            @ApiImplicitParam(name = "repeatPassword", value = "重复输入新密码", dataType = "String", required = true)

    })
    public ResultBody updatePassword(@RequestParam("oldPassword")String oldPassword,
                                  @RequestParam("newPassword")String newPassword,
                                  @RequestParam("repeatPassword")String repeatPassword,
                                  HttpServletRequest request) throws Exception {
        if(!newPassword.equals(repeatPassword)){
            throw new GlobalException("500", "2次输入的密码不同");
        }
        String userId = ParamUtil.getUserId(request);
        //密码加密
        oldPassword = Coder.encryptBASE64(oldPassword);
        newPassword = Coder.encryptBASE64(newPassword);
        Boolean flag = userService.updatePassword(userId, oldPassword, newPassword);
        System.out.println(flag);
        UserModel user = null;
        if(flag) {
            user = userService.getUserModelById(userId);
            String token = jwtConfig.createToken(userId);
            user.setToken(token);
        }
        return ResultBody.ResHandle(user, "修改密码失败");
    }


    /*
    * 注册
    * 获取验证码
    * */
    @PostMapping("/register")
    public ResultBody register(@RequestParam("studentId")String studentId,
                               @RequestParam("password")String password,
                               @RequestParam("userName")String userName,
                               @RequestParam("realName")String realName,
                               @RequestParam("sex")String sex,
                               @RequestParam("birthday")String birthday,
                               @RequestParam("enterSchoolTime")String enterSchoolTime,
                               @RequestParam("major")String major,
                               @RequestParam("email")String email,
                               @RequestParam("mobilePhone")String mobilePhone,
                               String selfImage) throws Exception {
        password = Coder.encryptBASE64(password);
        String activationCode = EmailUtils.makeActivationCode();
        boolean flag = userService.register(studentId, password, userName,mobilePhone , realName,
                sex, birthday, enterSchoolTime, major, email, selfImage,activationCode);
        EmailUtils.emailUTils(email,activationCode);
        return ResultBody.ResHandle(flag, "注册失败");
    }

    /*
    * 激活
    * */
    @PostMapping("/activation")
    public ResultBody activation(@RequestParam("studentId")String studentId,
                                 @RequestParam("password")String password,
                                 @RequestParam("activationCode")String activationCode) throws Exception {
        password = Coder.encryptBASE64(password);
        System.out.println(password);
        UserModel login = userService.login(studentId, password);
        if(login == null){
            return ResultBody.error("500", "登录失败");
        }
        if (login.getActivationCode().equals(activationCode)) {
            userMapper.updataStatus(1,login.getUserId());
            return ResultBody.success();
        }
        return ResultBody.ResHandle(null, "激活失败");
    }


    @GetMapping("/showOthersInfo")
    public ResultBody showOthersInfo(@RequestParam("userId") String userId){
        ShowSbPage2Pojo pojo = new ShowSbPage2Pojo();
        UserModel user = userService.getUserModelById(userId);
        if(user == null){
            return ResultBody.exception500("用户不存在");
        }
        pojo.setUserName(user.getUserName());
        pojo.setStudentId(user.getUserId());
        pojo.setSex(user.getSex());
        pojo.setBirthday(user.getBirthday());
        pojo.setMajor(user.getMajor());
        pojo.setSelfImage(user.getSelfImage());
        pojo.setIdolSum(user.getIdolSum());
        pojo.setFansSum(user.getFansSum());
        return ResultBody.success(pojo);
    }



}
