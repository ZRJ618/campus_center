package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.Question;
import com.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RestController
public class HomePage {
    @Autowired
    QuestionService questionService;

    /*
    * 已弃用
    * */
/*    @GetMapping("/homePage")
    public ResultBody homePage(){
        //设置timestamp为十天前
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-10);
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        //操作数据库：十天之内，按照其回答点赞总数排列，最多30条
        List<Question> questions = questionService.showHomePage(timestamp);
        return ResultBody.success(questions);
    }*/
}
