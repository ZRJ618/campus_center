package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Fans;
import com.demo.pojo.user.User;
import com.demo.service.FansService;
import com.demo.service.UserService1;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fans")
public class FansController {
    @Autowired
    FansService fansService;

    @Autowired
    UserService1 userService1;

    /*
    * 关注某人(由于关注与被关注都处于一张表，所以被关注就不用插入数据了，与关注是一样的)
    * userId:被关注者的id
    * */
    @PostMapping("/focusOther")
    public ResultBody focusOther(@RequestParam("userId") String userId, HttpServletRequest request) throws ParseException {
        String fansId = ParamUtil.getUserId(request);
        User self = userService1.selectUserByUserId(fansId);
        if(self == null){
            return ResultBody.exception500("该用户不存在");
        }
        //判断是否已经关注过了
        Fans fans = fansService.selectByUserIdAndFansId(userId,fansId);
        if(fans != null){
            return ResultBody.exception500("已经关注过了");
        }
        //执行关注操作
        fansService.insertUser(userId,fansId);
        //自己的关注者总数加一
        self.setIdolSum(self.getIdolSum() + 1);
        updateUser(self);
        //别人的粉丝总数加一
        User other = userService1.selectUserByUserId(userId);
        other.setFansSum(other.getFansSum() + 1);
        updateUser(other);
        return ResultBody.success();
    }

    /*
    * 取消关注
    * userId:被关注者的id
    * */
    @PostMapping("/cancelFocus")
    public ResultBody cancelFocus(@RequestParam("userId") String userId, HttpServletRequest request) throws ParseException {
        String fansId = ParamUtil.getUserId(request);
        //判断是否已经关注过了
        Fans fans = fansService.selectByUserIdAndFansId(userId,fansId);
        if(fans == null){
            return ResultBody.exception500("没有关注过，无法取消关注");
        }
        //执行删除关注操作
        fansService.deleteUser(userId,fansId);
        //自己的关注者总数减一
        User self = userService1.selectUserByUserId(fansId);
        self.setIdolSum(self.getIdolSum() - 1);
        updateUser(self);
        //别人的粉丝总数减一
        User other = userService1.selectUserByUserId(userId);
        other.setFansSum(other.getFansSum() - 1);
        updateUser(other);
        return ResultBody.success();
    }

    /*
    * 判断是否已经关注过了
    * userId:被关注者的id
    * */
    @PostMapping("/isFocus")
    public ResultBody isFocus(@RequestParam("userId") String userId, HttpServletRequest request){
        String fansId = ParamUtil.getUserId(request);
        Fans fans = fansService.selectByUserIdAndFansId(userId,fansId);
        if(fans == null){
            return ResultBody.exception500("没有关注过");
        }else {
            return new ResultBody("200","关注过了",null);
        }
    }


    /*
    * 查看关注数
    * */
    @PostMapping("/showFocusNum")
    public ResultBody showFocusNum(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        Integer focusNum = fansService.selectFocusNum(userId);
        return ResultBody.success(focusNum);
    }

    /*
     * 查看粉丝数
     * */
    @PostMapping("/showFansNum")
    public ResultBody showFansNum(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        Integer fansNum = fansService.selectFansNum(userId);
        return ResultBody.success(fansNum);
    }

    /*
     * 查看所有关注者
     * */
    @PostMapping("/showFocus")
    public ResultBody showFocus(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        List<Fans> focus = fansService.selectFocus(userId);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < focus.size(); i++) {
            User user = userService1.selectUserByUserId(focus.get(i).getUserId());
            users.add(user);
        }
        return ResultBody.success(users);
    }

    /*
     * 分页查询:查看所有关注者
     * 已弃用
     * */
/*    @PostMapping("/showFocusByPage")
    public ResultBody showFocusByPage(HttpServletRequest request, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String userId = ParamUtil.getUserId(request);
        List<Fans> focus = fansService.selectFocusByPage(userId,offSet,pageSize);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < focus.size(); i++) {
            User user = userService1.selectUserByUserId(focus.get(i).getUserId());
            users.add(user);
        }
        return ResultBody.success(users);
    }*/

    /*
     * 查看所有粉丝
     * */
    @PostMapping("/showFans")
    public ResultBody showFans(HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        List<Fans> fans = fansService.selectFans(userId);
        List<User> fans2 = new ArrayList<>();
        for (int i = 0; i < fans.size(); i++) {
            User user = userService1.selectUserByUserId(fans.get(i).getFansId());
            fans2.add(user);
        }
        return ResultBody.success(fans2);
    }

    /*
     * 分页查询:查看所有粉丝
     * 已弃用
     * */
/*    @PostMapping("/showFansByPage")
    public ResultBody showFansByPage(HttpServletRequest request, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String userId = ParamUtil.getUserId(request);
        List<Fans> fans = fansService.selectFansByPage(userId,offSet,pageSize);
        List<User> fans2 = new ArrayList<>();
        for (int i = 0; i < fans.size(); i++) {
            User user = userService1.selectUserByUserId(fans.get(i).getFansId());
            fans2.add(user);
        }
        return ResultBody.success(fans2);
    }*/


    private void updateUser(User user) throws ParseException {
        Date birthday = DateUtils.date(user.getBirthday());
        Date enterSchoolTime = DateUtils.date(user.getEnterSchoolTime());
        Timestamp createTime = DateUtils.timeStamp(user.getCreateTime());
        userService1.updateUser(user.getUserId(),user.getStudentId(),user.getPassword(),user.getUserName(),user.getRealName(),user.getSex(),
                birthday,enterSchoolTime,user.getMajor(),user.getMobilePhone(),user.getEmail(),user.getSelfImage(),
                createTime,user.getStatus(),user.getIdolSum(),user.getFansSum());
    }

}
