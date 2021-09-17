package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.Question;
import com.demo.service.AnswerLikeService;
import com.demo.service.AnswerService;
import com.demo.service.QuestionService;
import com.demo.service.ScanHistoryService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
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
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answer")
public class AnswerController2 {
    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;
    @Autowired
    AnswerLikeService answerLikeService;
    @Autowired
    ScanHistoryService scanHistoryService;

    /*
    * 根据answerId展示answer（同时需要展示出其question）
    * */
    @GetMapping("/showAnswer2/{answerId}")
    public ResultBody showAnswer(@PathVariable("answerId") String answerId, HttpServletRequest request) throws ParseException {
        List<Object> objects = new ArrayList<>();
        //查询answer
        ShowAnswerPojo pojo = new ShowAnswerPojo();
        Answer answer = answerService.selectAnswerById(answerId);
        //查询question
        ShowAnswerAboutQuestionPojo questionPojo = new ShowAnswerAboutQuestionPojo();
        Question question1 = questionService.selectQuestion(answer.getQuestionId());
        //为questionPojo赋值
        questionPojo.setQuestionId(question1.getQuestionId());
        questionPojo.setUserId(question1.getUserId());
        questionPojo.setTitle(question1.getTitle());
        questionPojo.setContent(question1.getContent());
        questionPojo.setAllAnswerLikeNum(question1.getAllAnswerLikeNum());
        questionPojo.setCreateTime(question1.getCreateTime());
        questionPojo.setQuestionImage(question1.getQuestionImage());
        questionPojo.setScanNum(question1.getScanNum());
        objects.add(questionPojo);
        //为pojo赋值
        if(answer == null){
            return ResultBody.exception500("answer不存在");
        }
        pojo.setAuthorId(answer.getUserId());
        //该answer是否是自己的
        if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
            pojo.setHasSelf(true);
        }else {
            pojo.setHasSelf(false);
        }
        //为pojo添加scanNum
        pojo.setScanNum(answer.getScanNum());
        //pojo其他的详细信息
        pojo.setAnswerId(answer.getAnswerId());
        pojo.setUserId(answer.getUserId());
        pojo.setContent(answer.getContent());
        pojo.setCreateTime(answer.getCreateTime());
        pojo.setLikeNum(answer.getLikeNum());
        pojo.setUnlikeNum(answer.getUnlikeNum());
        pojo.setCommentNum(answer.getCommentNum());
        objects.add(pojo);
        //添加浏览记录
        String selfId = ParamUtil.getUserId(request);
        String scanHistoryId = UUID.randomUUID().toString();
        String createTime = DateUtils.timestampToString(new Timestamp(new Date().getTime()));
        scanHistoryService.insertScanHistory(scanHistoryId,selfId,answerId,createTime);
        //该answer的浏览量加一
        answer.setScanNum(answer.getScanNum()+1);
        answerService.updateScanNum(answer.getScanNum(),answer.getAnswerId());
        //为该answer的question的浏览量加一
        Question question = questionService.selectQuestion(answer.getQuestionId());
        question.setScanNum(question.getScanNum()+1);
        questionService.updateAllAnswerScanNum(question.getScanNum(),question.getQuestionId());
        return ResultBody.success(objects);
    }


    /*
     * 分页查询:粗略展示某人的所有answer
     * */
    @GetMapping("/showAllAnswerByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllAnswerByPage(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                          HttpServletRequest request){
        ShowAllAnswerByPageResult result = new ShowAllAnswerByPageResult();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        //查询answers
        List<Answer> answers = answerService.selectAllAnswerByUserIdByPage(userId,offSet,pageSize);
        for (Answer answer : answers) {
            ShowAllAnswerByPagePojo pojo = new ShowAllAnswerByPagePojo();
            pojo.setAnswerId(answer.getAnswerId());
            pojo.setUserId(answer.getUserId());
            pojo.setQuestionId(answer.getQuestionId());
            pojo.setContent(answer.getContent());
            pojo.setCreateTime(answer.getCreateTime());
            pojo.setLikeNum(answer.getLikeNum());
            pojo.setUnlikeNum(answer.getUnlikeNum());
            pojo.setCommentNum(answer.getCommentNum());
            pojo.setScanNum(answer.getScanNum());
            if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
                pojo.setHasSelf(true);
            }else {
                pojo.setHasSelf(false);
            }
            //查询questionTitle
            Question question = questionService.selectQuestion(answer.getQuestionId());
            pojo.setQuestionTitle(question.getTitle());
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = answerService.selectAllAnswerByUserId(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }

}

@Data
class ShowAnswerPojo{
    String authorId;
    int scanNum;
    boolean hasSelf;//是否是自己的
    /*
    * answer详细信息
    * */
    String answerId;
    String userId;
    String content;
    String createTime;//插入时用Timestamp类型
    int likeNum;
    int unlikeNum;
    int commentNum;
}

@Data
class ShowAnswerAboutQuestionPojo{
     String questionId;
     String userId;
     String title;
     String content;
     int allAnswerLikeNum;
     String createTime;//插入时用Timestamp类型
     String questionImage;//question的封面图片
     int scanNum;
}

@Data
class ShowAllAnswerByPageResult{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}


@Data
class ShowAllAnswerByPagePojo{
    String answerId;
    String userId;
    String questionId;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String questionTitle;
    int scanNum;
    boolean hasSelf;//是否是自己的
}
