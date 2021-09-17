package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.CollectionQuestion;
import com.demo.pojo.Question;
import com.demo.service.CollectionQuestionService;
import com.demo.service.QuestionService;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collectionQuestion")
public class CollectionQuestionController {
    @Autowired
    CollectionQuestionService service;

    @Autowired
    QuestionService questionService;

    /*
    * 收藏question
    * */
    @PostMapping("/insert")
    public ResultBody CollectionQuestion(@RequestParam("questionId") String questionId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        //判断是否已经收藏过了
        CollectionQuestion collentionQuestion = service.selectQuestionByUserIdAndQuestionId(userId,questionId);
        if(collentionQuestion != null){
            return ResultBody.exception500("已经收藏过了");
        }
        service.insertCollection(userId,questionId);
        return ResultBody.success();
    }

    /*
     * 判断是否已经收藏过了
     * */
    @PostMapping("/isCollection")
    public ResultBody isCollection(@RequestParam("questionId") String questionId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        CollectionQuestion collentionQuestion = service.selectQuestionByUserIdAndQuestionId(userId,questionId);
        if(collentionQuestion != null){
            return new ResultBody("200","收藏过了",null);
        }else {
            return ResultBody.exception500("没有收藏过");
        }
    }



    /*
    * 删除收藏的question
    * */
    @PostMapping("/delete")
    public ResultBody deleteCollctionQuestion(@RequestParam("questionId") String questionId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        service.updateStatus(userId,questionId);
        return ResultBody.success();
    }

    /*
    * 展示某人收藏的question
    * */
    @GetMapping("/show/{userId}")
    public ResultBody showCollectionQuestion(@PathVariable("userId") String userId){
        List<CollectionQuestion> collentionQuestions = service.selectAllQuestionByUserId(userId);
        System.out.println(collentionQuestions);
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < collentionQuestions.size(); i++) {
            Question question = questionService.selectQuestion(collentionQuestions.get(i).getQuestionId());
            System.out.println(question);
            questions.add(question);
        }
        System.out.println(questions);
        return ResultBody.success(questions);
    }

    /*
     * 分页查询:展示某人收藏的question
     * 已弃用
     * */
/*    @GetMapping("/showByPage/{userId}/{pageNum}/{pageSize}")
    public ResultBody showCollectionQuestionByPage(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CollectionQuestion> collentionQuestions = service.selectAllQuestionByUserIdByPage(userId,offSet,pageSize);
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < collentionQuestions.size(); i++) {
            Question question = questionService.selectQuestion(collentionQuestions.get(i).getQuestionId());
            questions.add(question);
        }
        return ResultBody.success(questions);
    }*/
}
