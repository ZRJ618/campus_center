package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.Article;
import com.demo.pojo.ScanHistory;
import com.demo.service.AnswerService;
import com.demo.service.ArticleService;
import com.demo.service.ScanHistoryService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/scanHistory")
public class ScanHistoryCotroller {
    @Autowired
    ScanHistoryService scanHistoryService;

    @Autowired
    AnswerService answerService;

    @Autowired
    ArticleService articleService;

    /*
    * 添加一条浏览记录
    * */
    @PostMapping("/insert")
    public ResultBody insertHistory(@RequestParam("articleOrAnswerId") String articleOrAnswerId, HttpServletRequest request) throws ParseException {
        String userId = ParamUtil.getUserId(request);
        String scanHistoryId = UUID.randomUUID().toString();
        String createTime = DateUtils.timestampToString(new Timestamp(new Date().getTime()));
        scanHistoryService.insertScanHistory(scanHistoryId,userId,articleOrAnswerId,createTime);
        return ResultBody.success();
    }

    /*
    * 删除一条浏览记录（根据scanHistoryId）
    * */
    @PostMapping("/delete")
    public ResultBody deleteHistory(@RequestParam("scanHistoryId") String scanHistoryId){
        scanHistoryService.updateStatus(scanHistoryId);
        return ResultBody.success();
    }


    /*
    * 展示某人三天之内全部的浏览记录
    * */
    @PostMapping("/showAllLimitTime")
    public ResultBody showAllLimitTime(HttpServletRequest request) throws ParseException {
        String userId = ParamUtil.getUserId(request);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-3);
        String limitTime = DateUtils.timestampToString(new Timestamp(calendar.getTime().getTime()));
        List<ScanHistory> scanHistories = scanHistoryService.showAllByUserIdLimitTime(userId,limitTime);
        List<Object> objects = new ArrayList<>();
        Answer answer = null;
        Article article = null;
        for (int i = 0; i < scanHistories.size(); i++) {
            answer = answerService.selectAnswerById(scanHistories.get(i).getArticleOrAnswerId());
            if(answer == null){
                article = articleService.selectArticleById(scanHistories.get(i).getArticleOrAnswerId());
                objects.add(article);
            }else {
                objects.add(answer);
            }
        }
        return ResultBody.success(objects);
    }

    /*
     * 分页查询:展示某人三天之内全部的浏览记录
     * */
    @PostMapping("/showAllLimitTimeByPage")
    public ResultBody showAllLimitTimeByPage(HttpServletRequest request, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) throws ParseException {
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String userId = ParamUtil.getUserId(request);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-3);
        String limitTime = DateUtils.timestampToString(new Timestamp(calendar.getTime().getTime()));
        List<ScanHistory> scanHistories = scanHistoryService.showAllByUserIdLimitTimeByPage(userId,limitTime,offSet,pageSize);
        List<Object> objects = new ArrayList<>();
        Answer answer = null;
        Article article = null;
        for (int i = 0; i < scanHistories.size(); i++) {
            answer = answerService.selectAnswerById(scanHistories.get(i).getArticleOrAnswerId());
            if(answer == null){
                article = articleService.selectArticleById(scanHistories.get(i).getArticleOrAnswerId());
                objects.add(article);
            }else {
                objects.add(answer);
            }
        }
        return ResultBody.success(objects);
    }
}
