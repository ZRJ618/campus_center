package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Fans;
import com.demo.pojo.user.User;
import com.demo.service.FansService;
import com.demo.service.UserService1;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fans")
public class FansController2 {
    @Autowired
    FansService fansService;
    @Autowired
    UserService1 userService1;


    /*
     * 分页查询:查看所有关注者
     * */
    @GetMapping("/showFocusByPage2/{pageNum}/{pageSize}")
    public ResultBody showFocusByPage2(HttpServletRequest request, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        FansController2Result result = new FansController2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String selfId = ParamUtil.getUserId(request);
        //查询所有关注者
        List<Fans> focus = fansService.selectFocusByPage(selfId,offSet,pageSize);
        for (int i = 0; i < focus.size(); i++) {
            User user = userService1.selectUserByUserId(focus.get(i).getUserId());
            ShowFocusByPage2Pojo pojo = new ShowFocusByPage2Pojo();
            pojo.setUserId(user.getUserId());
            pojo.setUserName(user.getUserName());
            pojo.setSelfImage(user.getSelfImage());
            //添加详细信息
            pojo.setStudentId(user.getStudentId());
            pojo.setRealName(user.getRealName());
            pojo.setSex(user.getSex());
            pojo.setBirthday(user.getBirthday());
            pojo.setEnterSchoolTime(user.getEnterSchoolTime());
            pojo.setMajor(user.getMajor());
            pojo.setCreateTime(user.getCreateTime());
            pojo.setIdolSum(user.getIdolSum());
            pojo.setFansSum(user.getFansSum());
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = fansService.selectFocus(selfId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }


    /*
     * 分页查询:查看所有粉丝
     * */
    @GetMapping("/showFansByPage2/{pageNum}/{pageSize}")
    public ResultBody showFansByPage2(HttpServletRequest request, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        FansController2Result result = new FansController2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String selfId = ParamUtil.getUserId(request);
        //查询fans
        List<Fans> fans = fansService.selectFansByPage(selfId,offSet,pageSize);
        for (int i = 0; i < fans.size(); i++) {
            User user = userService1.selectUserByUserId(fans.get(i).getFansId());
            ShowFansByPage2Pojo pojo = new ShowFansByPage2Pojo();
            pojo.setUserId(user.getUserId());
            pojo.setUserName(user.getUserName());
            pojo.setSelfImage(user.getSelfImage());
            //是否关注该fans
            Fans fans2 = fansService.selectByUserIdAndFansId(user.getUserId(),selfId);
            if(fans2 == null){
                pojo.setHasFocus(false);
            }else {
                pojo.setHasFocus(true);
            }
            //添加详细信息
            pojo.setStudentId(user.getStudentId());
            pojo.setRealName(user.getRealName());
            pojo.setSex(user.getSex());
            pojo.setBirthday(user.getBirthday());
            pojo.setEnterSchoolTime(user.getEnterSchoolTime());
            pojo.setMajor(user.getMajor());
            pojo.setCreateTime(user.getCreateTime());
            pojo.setIdolSum(user.getIdolSum());
            pojo.setFansSum(user.getFansSum());
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = fansService.selectFans(selfId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }
}

@Data
class FansController2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}


@Data
class ShowFocusByPage2Pojo{
    String userId;
    String userName;
    String selfImage;
    /*
    * focus的详细信息
    * */
    String studentId;
    String realName;
    String sex;
    String birthday;//插入时用sql.date类型
    String enterSchoolTime;//插入时用sql.date类型
    String major;
    String createTime;
    int idolSum;
    int fansSum;
}

@Data
class ShowFansByPage2Pojo{
    String userId;
    String userName;
    String selfImage;
    boolean hasFocus;
    /*
     * fans的详细信息
     * */
    String studentId;
    String realName;
    String sex;
    String birthday;
    String enterSchoolTime;
    String major;
    String createTime;
    int idolSum;
    int fansSum;
}
