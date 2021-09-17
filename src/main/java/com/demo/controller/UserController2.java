package com.demo.controller;



import com.demo.config.JwtConfig;
import com.demo.exception.ResultBody;

import com.demo.mapper.UserMapper;
import com.demo.pojo.user.User;
import com.demo.service.UserService1;
import com.demo.util.DateUtils;
import com.demo.util.ParamUtil;
import com.demo.util.UploadImage;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;

@RestController
@RequestMapping("/user")
public class UserController2 {
    @Autowired
    UserService1 userService1;
    @Autowired
    UserMapper userMapper;
    @Resource
    JwtConfig jwtConfig;


    /*
     * 上传头像并返回图片的URL
     * */
    @PostMapping("/uploadSelfImage2")
    public ResultBody uploadSelfImage2(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String imageURI = UploadImage.uploacImage(multipartFile,"/static/selfImage/");
        String imageURL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+imageURI;
        return ResultBody.success(imageURL);
    }


    /*
    * 修改个人信息
    * */
    @PostMapping("/fixSelfInfo2")
    public ResultBody fixSelfInfo2(@RequestParam("selfImageUrl") String selfImageUrl, @RequestParam("studentId") String studentId,
                                   @RequestParam("userName") String userName, @RequestParam("realName") String realName, @RequestParam("sex") String sex,
                                   @RequestParam("birthday") String birthday, @RequestParam("enterSchoolTime")  String enterSchoolTime,
                                   @RequestParam("major") String major, @RequestParam("mobilePhone") String mobilePhone,
                                   @RequestParam("email") String email, HttpServletRequest request) throws ParseException {
        //获取当前user
        User user = userService1.selectUserByUserId(ParamUtil.getUserId(request));
        //操作数据库
        Date newBirthday = DateUtils.date(birthday);
        Date newEnterSchoolTime = DateUtils.date(enterSchoolTime);
        Timestamp createTime = DateUtils.timeStamp(user.getCreateTime());
        String token = jwtConfig.createToken(ParamUtil.getUserId(request));
        userMapper.updateUser(user.getUserId(),studentId,user.getPassword(),userName,realName,
                sex,newBirthday,newEnterSchoolTime,major,mobilePhone,
                email,selfImageUrl,createTime,user.getStatus(),user.getIdolSum(),
                user.getFansSum());
        return ResultBody.success(token);
    }


    /*
    * 注销账户
    * */
    @PostMapping("/fixSelfstatus2")
    public ResultBody fixSelfstatus2(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        int status = 0;
        userMapper.updataStatus(status,userId);
        return ResultBody.success();
    }


    /*
    * 展示他人的的主页信息
    * */
    @GetMapping("/showSbPage2/{userId}")
    public ResultBody showSbPage2(@PathVariable("userId") String userId, HttpServletRequest request){
        ShowSbPage2Pojo pojo = new ShowSbPage2Pojo();
        User user = userService1.selectUserByUserId(userId);
        if(user == null){
            return ResultBody.exception500("用户不存在");
        }
        pojo.setUserName(user.getUserName());
        pojo.setStudentId(user.getUserId());
        pojo.setSex(user.getSex());
        pojo.setBirthday(user.getBirthday());
        pojo.setEnterSchoolTime(user.getEnterSchoolTime());
        pojo.setMajor(user.getMajor());
        pojo.setSelfImage(user.getSelfImage());
        pojo.setCreateTime(user.getCreateTime());
        pojo.setIdolSum(user.getIdolSum());
        pojo.setFansSum(user.getFansSum());
        return ResultBody.success(pojo);
    }

    /*
     * 展示自己的的主页信息
     * */
    @GetMapping("/showSelfPage2")
    public ResultBody showSelfPage2(HttpServletRequest request){
        ShowSelfPage2Pojo pojo = new ShowSelfPage2Pojo();
        User user = userService1.selectUserByUserId(ParamUtil.getUserId(request));
        if(user == null){
            return ResultBody.exception500("用户不存在");
        }
        pojo.setUserId(user.getUserId());
        pojo.setStudentId(user.getStudentId());
        pojo.setUserName(user.getUserName());
        pojo.setRealName(user.getRealName());
        pojo.setSex(user.getSex());
        pojo.setBirthday(user.getBirthday());
        pojo.setEnterSchoolTime(user.getEnterSchoolTime());
        pojo.setMajor(user.getMajor());
        pojo.setMobilePhone(user.getMobilePhone());
        pojo.setEmail(user.getEmail());
        pojo.setSelfImage(user.getSelfImage());
        pojo.setCreateTime(user.getCreateTime());
        pojo.setIdolSum(user.getIdolSum());
        pojo.setFansSum(user.getFansSum());
        return ResultBody.success(pojo);
    }


}

@Data
class ShowSbPage2Pojo{
    String userName;
    String studentId;
    String sex;
    String birthday;
    String enterSchoolTime;
    String major;
    String selfImage;
    String createTime;
    int idolSum;
    int fansSum;
}

@Data
class ShowSelfPage2Pojo{
    String userId;
    String studentId;
    String userName;
    String realName;
    String sex;
    String birthday;
    String enterSchoolTime;
    String major;
    String mobilePhone;
    String email;
    String selfImage;
    String createTime;
    int idolSum;
    int fansSum;
}
