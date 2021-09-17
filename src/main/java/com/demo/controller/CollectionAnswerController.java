package com.demo.controller;


import com.demo.cache.CollectionAnswerCache;
import com.demo.exception.ResultBody;
import com.demo.pojo.Answer;
import com.demo.pojo.CollectionAnswer;
import com.demo.service.AnswerService;
import com.demo.service.CollectionAnswerService;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collectionAnswer")
public class CollectionAnswerController {
    @Autowired
    CollectionAnswerService service;

    @Autowired
    AnswerService answerService;

    @Autowired
    CollectionAnswerCache collectionAnswerCache;


    /*
    * 收藏answer
    * */
    @PostMapping("/insert")
    public ResultBody CollectionAnswer(@RequestParam("answerId") String answerId, HttpServletRequest request) throws NoSuchMethodException {
        if (collectionAnswerCache.CollectionAnswer(answerId, request)) {
            return ResultBody.success();
        }
        return ResultBody.exception500("操作失败");
    }

    /*
    * 判断是否已经收藏过了
    * */
    @PostMapping("/isCollection")
    public ResultBody isCollection(@RequestParam("answerId") String answerId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        CollectionAnswer collectionAnswer = service.selectAnswerByUserIdAndAnswerId(userId,answerId);
        if(collectionAnswer != null){
            return new ResultBody("200","收藏过",null);
        }else {
            return ResultBody.exception500("没有收藏过");
        }
    }


    /*
    * 删除收藏的answer
    * */
    @PostMapping("/delete")
    public ResultBody deleteCollctionAnswer(@RequestParam("answerId") String answerId, HttpServletRequest request) throws NoSuchMethodException {
        if (collectionAnswerCache.deleteCollctionAnswer(answerId,request) == true) {
            return ResultBody.success();
        }
        return ResultBody.exception500("操作失败");
    }


    /*
    * 展示某人收藏的answer
    * */
    @GetMapping("/show/{userId}")
    public ResultBody showCollectionAnswer(@PathVariable("userId") String userId) throws NoSuchMethodException {
        List<Answer> answers = collectionAnswerCache.showCollectionAnswer(userId);
        return ResultBody.success(answers);
    }

}
