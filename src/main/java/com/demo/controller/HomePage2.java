package com.demo.controller;

import com.demo.cache.HomePageCache;
import com.demo.exception.ResultBody;
import com.demo.pojo.Question;
import com.demo.service.QuestionService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class HomePage2 {
    @Autowired
    private HomePageCache homePageCache;

    @Autowired


    @GetMapping("/homePage2")
    public ResultBody homePage2(){
        List<HomePageCache.HomePage2Pojo> homePage2Pojos = homePageCache.homePage2();
        return ResultBody.success(homePage2Pojos);
    }
}


