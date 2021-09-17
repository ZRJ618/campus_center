package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.AnswerLike;
import com.demo.pojo.Question;
import com.demo.service.AnswerLikeService;
import com.demo.service.AnswerService;
import com.demo.service.QuestionService;
import com.demo.service.ScanHistoryService;
import com.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @Autowired
    AnswerLikeService answerLikeService;

    @Autowired
    ScanHistoryService scanHistoryService;


    /*
    * 上传回答中的图片并返回URL
    * */
    @PostMapping("/uploadAnswerImage")
    public ResultBody uploadAnswerImage(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String imageURL = UploadImage.uploacImage(multipartFile,"/static/answerImage/",request);
        return ResultBody.success(imageURL);
    }


    /*
    * 上传一篇回答,并返回answerId
    * */
    @PostMapping("/uploadAnswer")
    public ResultBody uploadAnswer(@RequestParam("questionId") String questionId, @RequestParam("content") String content, HttpServletRequest request){
        String answerId = UUID.randomUUID().toString();
        String userId = ParamUtil.getUserId(request);
        Timestamp createTime = new Timestamp(new Date().getTime());
        int likeNum = 0;
        int unlikeNum = 0;
        int commentNum = 0;
        int status = 1;
        //操作数据库
        answerService.insertAnswer(answerId,questionId,userId,content,createTime,likeNum,unlikeNum,commentNum,status);
        return ResultBody.success(answerId);
    }

    /*
    * 根据answerId展示answer（同时需要展示出其question）
    * 已弃用
    * */
/*    @GetMapping("/showAnswer/{answerId}")
    public ResultBody showAnswer(@PathVariable("answerId") String answerId, HttpServletRequest request) throws ParseException {
        Answer answer = answerService.selectAnswerById(answerId);
        String questionId = answer.getQuestionId();
        Question question = questionService.selectQuestion(questionId);
        Object[] objects = {question,answer};
        //添加浏览记录
        String selfId = ParamUtil.getUserId(request);
        String scanHistoryId = UUID.randomUUID().toString();
        String createTime = DateUtils.timestampToString(new Timestamp(new Date().getTime()));
        scanHistoryService.insertScanHistory(scanHistoryId,selfId,answerId,createTime);
        return ResultBody.success(objects);
    }*/

    /*
     * 删除某篇answer
     * */
    @PostMapping("/deleteAnswer")
    public ResultBody deleteAnswer(@RequestParam("answerId") String answerId){
        answerService.deleteAnswer(answerId);
        return ResultBody.success();
    }

    /*
    * 粗略展示某人的所有answer
    * */
    @GetMapping("/showAllAnswer/{userId}")
    public ResultBody showAllAnswer(@PathVariable("userId") String userId){
        List<Answer> answers = answerService.selectAllAnswerByUserId(userId);
        return ResultBody.success(answers);
    }

    /*
     * 分页查询:粗略展示某人的所有answer
     * 已弃用
     * */
/*    @GetMapping("/showAllAnswerByPage/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllAnswerByPage(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<Answer> answers = answerService.selectAllAnswerByUserIdByPage(userId,offSet,pageSize);
        return ResultBody.success(answers);
    }*/


    /*
    * 修改answer：content
    * */
    @PostMapping("/fixAnswer")
    public ResultBody fixAnswer(@RequestParam("answerId") String answerId, @RequestParam("content") String content){
        Answer answer = answerService.selectAnswerById(answerId);
        if(answer == null){
            return ResultBody.exception500("该answer不存在");
        }
        answerService.updateContent(content,answerId);
        return ResultBody.success();
    }

    /*
    * 为一篇answer点赞(同时将answer的question的总点赞数加一)
    * */
    @PostMapping("/likeAnswer")
    public ResultBody likeAnswer(@RequestParam("answerId") String answerId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        Answer answer = answerService.selectAnswerById(answerId);
        if(answer == null){
            return ResultBody.exception500("该answer不存在");
        }
        //是否已经点过赞了（answer_like表中是否已存在）
        AnswerLike answerLike = answerLikeService.selectByUserIdAndAnswerId(userId,answerId);
        if(answerLike != null){
            return ResultBody.exception500("已经点过赞了");
        }
        //将answer点赞数加一
        answer.setLikeNum(answer.getLikeNum() + 1);
        answerService.updateLikeNum(answer.getLikeNum(),answerId);
        //将该answer的question的总点赞数加一
        Question question = questionService.selectQuestion(answer.getQuestionId());
        question.setAllAnswerLikeNum(question.getAllAnswerLikeNum() + 1);
        questionService.updateAllAnswerLikeNum(question.getAllAnswerLikeNum(),question.getQuestionId());
        //在answer_like表中记录
        answerLikeService.insertAnswerLike(userId,answerId);
        return ResultBody.success();
    }

    /*
    * 取消点赞
    * */
    @PostMapping("/cancelLikeAnswer")
    public ResultBody cancleLikeAnswer(@RequestParam("answerId") String answerId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        Answer answer = answerService.selectAnswerById(answerId);
        //是否已经点过赞了（answer_like表中是否已存在）
        AnswerLike answerLike = answerLikeService.selectByUserIdAndAnswerId(userId,answerId);
        if(answerLike == null){
            return ResultBody.exception500("没有对其进行点赞，无法取消点赞");
        }
        //将answer点赞数减一
        answer.setLikeNum(answer.getLikeNum() - 1);
        answerService.updateLikeNum(answer.getLikeNum(),answerId);
        //将该answer的question的总点赞数减一
        Question question = questionService.selectQuestion(answer.getQuestionId());
        question.setAllAnswerLikeNum(question.getAllAnswerLikeNum() - 1);
        questionService.updateAllAnswerLikeNum(question.getAllAnswerLikeNum(),question.getQuestionId());
        //在answer_like表中删除该记录
        answerLikeService.deleteAnswerLike(userId,answerId);
        return ResultBody.success();
    }

    /*
    * 查看是否为某answer点过赞
    * */
    @PostMapping("/isLikeAnswer")
    public ResultBody isLikeAnswer(@RequestParam("answerId") String answerId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        //是否已经点过赞了（answer_like表中是否已存在）
        AnswerLike answerLike = answerLikeService.selectByUserIdAndAnswerId(userId,answerId);
        if(answerLike != null){
            return new ResultBody("200","点过赞了",null);
        }else {
            return ResultBody.exception500("没有点过赞");
        }
    }

}
