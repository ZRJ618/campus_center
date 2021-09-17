package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.Article;
import com.demo.pojo.ScanHistory;
import com.demo.service.*;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/scanHistory")
public class ScanHistoryCotroller2 {
    @Autowired
    ScanHistoryService scanHistoryService;
    @Autowired
    AnswerService answerService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService1 userService1;
    @Autowired
    QuestionService questionService;

    /*
     * 分页查询:展示某人三天之内全部的浏览记录
     * */
    @GetMapping("/showAllLimitTimeByPage2/{pageNum}/{pageSize}")
    public ResultBody showAllLimitTimeByPage2(HttpServletRequest request, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws ParseException {
        ShowAllLimitTimeByPage2Result result = new ShowAllLimitTimeByPage2Result();
        List<Object> objects = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        String selfId = ParamUtil.getUserId(request);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-3);
        String limitTime = DateUtils.timestampToString(new Timestamp(calendar.getTime().getTime()));
        List<ScanHistory> scanHistories = scanHistoryService.showAllByUserIdLimitTimeByPage(selfId,limitTime,offSet,pageSize);
        Answer answer = null;
        Article article = null;
        for (int i = 0; i < scanHistories.size(); i++) {
            answer = answerService.selectAnswerById(scanHistories.get(i).getArticleOrAnswerId());
            article = articleService.selectArticleById(scanHistories.get(i).getArticleOrAnswerId());
            if(answer == null & article != null){
                //为article
                com.demo.controller.showAllLimitTimeByPage2AboutArticlePojo pojo = new com.demo.controller.showAllLimitTimeByPage2AboutArticlePojo();
                pojo.setArticleId(article.getArticleId());
                pojo.setTitle(article.getTitle());
                pojo.setAuthorName(userService1.selectUserByUserId(article.getUserId()).getUserName());
                pojo.setContent(article.getContent());
                pojo.setLikeNum(article.getLikeNum());
                pojo.setCommentNum(article.getCommentNum());
                //判断是否是自己的
                if (article.getUserId().equals(ParamUtil.getUserId(request))) {
                    pojo.setHasSelf(true);
                }else {
                    pojo.setHasSelf(false);
                }
                objects.add(pojo);
            }else if(answer != null & article == null){
                //为answer
                com.demo.controller.showAllLimitTimeByPage2AboutAnswerPojo pojo = new com.demo.controller.showAllLimitTimeByPage2AboutAnswerPojo();
                pojo.setAnswerId(answer.getAnswerId());
                pojo.setQuestionTitle(questionService.selectQuestion(answer.getQuestionId()).getTitle());
                pojo.setQuestionImage(questionService.selectQuestion(answer.getQuestionId()).getQuestionImage());
                pojo.setAuthorName(userService1.selectUserByUserId(answer.getUserId()).getUserName());
                pojo.setAnswerContent(answer.getContent());
                pojo.setLikeNum(answer.getLikeNum());
                pojo.setCommentNum(answer.getCommentNum());
                //判断是否是自己的
                if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
                    pojo.setHasSelf(true);
                }else {
                    pojo.setHasSelf(false);
                }
                objects.add(pojo);
            }
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = scanHistoryService.showAllByUserIdLimitTime(selfId, limitTime).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = objects;
        //返回结果
        return ResultBody.success(result);
    }
}

@Data
class ShowAllLimitTimeByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class showAllLimitTimeByPage2AboutAnswerPojo{
    String answerId;
    String questionTitle;
    String questionImage;
    String authorName;
    String answerContent;
    int likeNum;
    int commentNum;
    boolean hasSelf;//是否是自己的
}

@Data
class showAllLimitTimeByPage2AboutArticlePojo{
    String articleId;
    String title;
    String authorName;
    String content;
    int likeNum;
    int commentNum;
    boolean hasSelf;//是否是自己的
}
