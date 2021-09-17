package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.exception.SelfDefindException;
import com.demo.pojo.*;
import com.demo.pojo.user.User;
import com.demo.service.*;
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
@RequestMapping("/question")
public class QuestionController2 {
    @Autowired
    QuestionService questionService;
    @Autowired
    LabelService labelService;
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService1 userService1;
    @Autowired
    FansService fansService;
    @Autowired
    CollectionQuestionService collectionQuestionService;
    @Autowired
    AnswerLikeService answerLikeService;
    @Autowired
    CollectionAnswerService collectionAnswerService;

    /*
    * 展示一个question（该question及它所有的answer）
    * */
/*    @GetMapping("/showQuestion2/{questionId}")
    public ResultBody showQuestion(@PathVariable("questionId") String questionId, HttpServletRequest request){
        List<Object> objects = new ArrayList<>();
        ShowQuestionAboutQuestionPoje questionPoje = new ShowQuestionAboutQuestionPoje();
        List<ShowQuestionAboutAnswerPoje> answerPojes = new ArrayList<>();
        //查询question
        Question question = questionService.selectQuestion(questionId);
        questionPoje.setQuestionAuthorId(question.getUserId());
        questionPoje.setContent(question.getContent());
        //查询question作者头像
        User questionAuthor = userService1.selectUserByUserId(question.getUserId());
        questionPoje.setAuthorImage(questionAuthor.getSelfImage());
        //是否是自己的
        if (question.getUserId().equals(ParamUtil.getUserId(request))) {
            questionPoje.setHasSelf(true);
        }else {
            questionPoje.setHasSelf(false);
        }
        //查询question作者名字
        questionPoje.setAuthorName(questionAuthor.getUserName());
        //是否关注question的作者
        String selfId = ParamUtil.getUserId(request);
        Fans fans = fansService.selectByUserIdAndFansId(questionAuthor.getUserId(),selfId);
        if(fans == null){
            questionPoje.setHasFocus(false);
        }else {
            questionPoje.setHasFocus(true);
        }
        //添加qiestion的详细信息
        questionPoje.setQuestionId(question.getQuestionId());
        questionPoje.setTitle(question.getTitle());
        questionPoje.setAllAnswerLikeNum(question.getAllAnswerLikeNum());
        questionPoje.setCreateTime(question.getCreateTime());
        questionPoje.setQuestionImage(question.getQuestionImage());
        //将该question的浏览量加一
        question.setScanNum(question.getScanNum()+1);
        questionService.updateAllAnswerScanNum(question.getScanNum(),question.getQuestionId());
        //为questionPoje添加scanNum
        questionPoje.setScanNum(question.getScanNum());
        objects.add(questionPoje);
        //查找该question的所有的回答
        List<Answer> answers = answerService.selectAllAnswerByQuestionId(questionId);
        for (Answer answer : answers) {
            ShowQuestionAboutAnswerPoje answerPoje = new ShowQuestionAboutAnswerPoje();
            answerPoje.setAnswerId(answer.getAnswerId());
            answerPoje.setContent(answer.getContent());
            answerPoje.setCreateTime(answer.getCreateTime());
            answerPoje.setLikeNum(answer.getLikeNum());
            answerPoje.setUnlikeNum(answer.getUnlikeNum());
            answerPoje.setCommentNum(answer.getCommentNum());
            answerPoje.setScanNum(answer.getScanNum());
            //是否是自己的
            if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
                answerPoje.setHasSelf(true);
            }else {
                answerPoje.setHasSelf(false);
            }
            //查询answer作者头像
            User answerAuthor = userService1.selectUserByUserId(question.getUserId());
            answerPoje.setAuthorImage(answerAuthor.getSelfImage());
            //查询answer作者名字
            answerPoje.setAuthorName(answerAuthor.getUserName());
            answerPojes.add(answerPoje);
        }
        objects.add(answerPojes);
        return ResultBody.success(objects);
    }*/


    /*
     * 分页查询:粗略展示某人的所有question
     * */
    @GetMapping("/showAllQuestionByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllQuestionByPage(@PathVariable String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                            HttpServletRequest request){
        ShowAllQuestionByPageResult result = new ShowAllQuestionByPageResult();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        //查询某人所有question
        List<Question> questionList = questionService.selectAllQuestionByUserIdByPage(userId,offSet,pageSize);
        for (Question question : questionList) {
            ShowAllQuestionByPagePojo pojo = new ShowAllQuestionByPagePojo();
            pojo.setQuestionId(question.getQuestionId());
            pojo.setUserId(question.getUserId());
            pojo.setContent(question.getContent());
            pojo.setTitle(question.getTitle());
            pojo.setAllAnswerLikeNum(question.getAllAnswerLikeNum());
            pojo.setCreateTime(question.getCreateTime());
            pojo.setQuestionImage(question.getQuestionImage());
            pojo.setScanNum(question.getScanNum());
            //判断是否是自己的
            if (question.getUserId().equals(ParamUtil.getUserId(request))) {
                pojo.setHasSelf(true);
            }else {
                pojo.setHasSelf(false);
            }
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = questionService.selectAllQuestionByUserId(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }

    /*
     * 分页展示某个question的所有回答（包含question本身）
     * */
    @GetMapping("/showQuestionByPage3/{questionId}/{pageNum}/{pageSize}")
    public ResultBody showQuestionByPage3(@PathVariable("questionId") String questionId, @PathVariable("pageNum") int pageNum,
                                          @PathVariable("pageSize") int pageSize, HttpServletRequest request){
        ShowQuestionByPage3Result result = new ShowQuestionByPage3Result();
        List<Object> objects = new ArrayList<>();
        String selfId = ParamUtil.getUserId(request);
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        //获取question
        Question question = questionService.selectQuestion(questionId);
        //判断该question是否存在
        if(question == null){
            throw new SelfDefindException("500","该question已被删除",null);
        }
        //是否有收藏该question
        CollectionQuestion collentionQuestion = collectionQuestionService.selectQuestionByUserIdAndQuestionId(selfId,questionId);
        boolean hascollectionQuestion = false;  //设置默认值为false
        if(collentionQuestion != null){
            hascollectionQuestion = true;
        }else {
            hascollectionQuestion = false;
        }
        //该question是否是自己的
        boolean hasSelf = false;
        if (question.getUserId().equals(ParamUtil.getUserId(request))) {
            hasSelf = true;
        }else {
            hasSelf = false;
        }
        //是否关注question的作者
        Fans fans = fansService.selectByUserIdAndFansId(question.getUserId(),selfId);
        boolean hasFocusQuestionAuthor = false;  //设置默认值为false
        if(fans == null){
            hasFocusQuestionAuthor = false;
        }else {
            hasFocusQuestionAuthor = true;
        }
        //获取question的作者
        User questionUser = userService1.selectUserByUserId(question.getUserId());
        ShowQuestionByPage3AboutQuestionPojo questionPojo = new ShowQuestionByPage3AboutQuestionPojo();
        setShowQuestionByPage3AboutQuestionPojo(questionPojo,question.getQuestionId(),question.getUserId(),question.getTitle(),question.getContent(),
                question.getAllAnswerLikeNum(),question.getCreateTime(),question.getQuestionImage(),hascollectionQuestion,hasFocusQuestionAuthor,
                question.getScanNum(),hasSelf,questionUser.getSelfImage(),questionUser.getUserName());
        objects.add(questionPojo);
        //分页查找其回答
        List<Answer> answers = answerService.selectAllAnswerByQuestionIdByPage(questionId,offSet,pageSize);
        List<ShowQuestionByPage3AboutAnswerPojo> answerPojos = new ArrayList<>();
        answers.forEach(answer -> {
            ShowQuestionByPage3AboutAnswerPojo answerPojo = new ShowQuestionByPage3AboutAnswerPojo();
            //是否点赞过该answer
            AnswerLike answerLike = answerLikeService.selectByUserIdAndAnswerId(selfId,answer.getAnswerId());
            boolean hasLikeAnswer = false;  //设置默认值为false
            if(answerLike != null){
                hasLikeAnswer = true;
            }else {
                hasLikeAnswer = false;
            }
            //是否收藏过该answer
            CollectionAnswer collectionAnswer = collectionAnswerService.selectAnswerByUserIdAndAnswerId(selfId,answer.getAnswerId());
            boolean hasCollectionAnswer = false;  //设置默认值为false
            if(collectionAnswer != null){
                hasCollectionAnswer = true;
            }else {
                hasCollectionAnswer = false;
            }
            //是否是自己的
            boolean hasSelf2 = false;
            if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
                hasSelf2 = true;
            }else {
                hasSelf2 = false;
            }
            //是否关注过该answer的作者
            Fans fans2 = fansService.selectByUserIdAndFansId(answer.getUserId(),selfId);
            boolean hasFocusAnswerAuthor = false;  //设置默认值为false
            if(fans == null){
                hasFocusAnswerAuthor = false;
            }else {
                hasFocusAnswerAuthor = true;
            }
            //获取answer的作者
            User answerUser = userService1.selectUserByUserId(answer.getUserId());
            setShowQuestionByPage3AboutAnswerPojo(answerPojo,answer.getAnswerId(),answer.getUserId(),answer.getContent(),answer.getCreateTime(),
                    answer.getLikeNum(),answer.getUnlikeNum(),answer.getCommentNum(),hasLikeAnswer,hasCollectionAnswer,
                    hasFocusAnswerAuthor,answer.getScanNum(),hasSelf2,answerUser.getSelfImage(),answerUser.getUserName());
            answerPojos.add(answerPojo);
        });
        objects.add(answerPojos);
        //添加三天之内该question的所有answer的总条数与所有的页面数
        int allDataNum = answerService.selectAllAnswerByQuestionId(questionId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = objects;
        return ResultBody.success(result);
    }





    public ShowQuestionByPage3AboutQuestionPojo setShowQuestionByPage3AboutQuestionPojo(ShowQuestionByPage3AboutQuestionPojo questionPojo,
                                                                                        String questionId, String userId, String title, String content, int allAnswerLikeNum,
                                                                                        String createTime, String questionImage, boolean hasCollection, boolean hasFocus,
                                                                                        int scanNum, boolean hasSelf, String authorImage, String authorName){
        questionPojo.setQuestionId(questionId);
        questionPojo.setUserId(userId);
        questionPojo.setTitle(title);
        questionPojo.setContent(content);
        questionPojo.setAllAnswerLikeNum(allAnswerLikeNum);
        questionPojo.setCreateTime(createTime);
        questionPojo.setQuestionImage(questionImage);
        questionPojo.setHasCollection(hasCollection);
        questionPojo.setHasFocus(hasFocus);
        questionPojo.setScanNum(scanNum);
        questionPojo.setHasSelf(hasSelf);
        questionPojo.setAuthorImage(authorImage);
        questionPojo.setAuthorName(authorName);
        return questionPojo;
    }
    public ShowQuestionByPage3AboutAnswerPojo setShowQuestionByPage3AboutAnswerPojo(ShowQuestionByPage3AboutAnswerPojo answerPojo,
                                                                                    String answerId, String userId, String content, String createTime, int likeNum,
                                                                                    int unlikeNum, int commentNum, boolean hasLike, boolean hasCollection, boolean hasFocus,int scanNum,
                                                                                    boolean hasSelf, String authorImage, String authorName){
        answerPojo.setAnswerId(answerId);
        answerPojo.setUserId(userId);
        answerPojo.setAuthorImage(authorImage);
        answerPojo.setAuthorName(authorName);
        answerPojo.setContent(content);
        answerPojo.setCreateTime(createTime);
        answerPojo.setLikeNum(likeNum);
        answerPojo.setUnlikeNum(unlikeNum);
        answerPojo.setCommentNum(commentNum);
        answerPojo.setHasLike(hasLike);
        answerPojo.setHasCollection(hasCollection);
        answerPojo.setHasFocus(hasFocus);
        answerPojo.setScanNum(scanNum);
        answerPojo.setHasSelf(hasSelf);
        return answerPojo;
    }

}

/*@Data
class ShowQuestionAboutQuestionPoje{
    String questionAuthorId;
    String content;
    String authorImage;
    String authorName;
    boolean hasFocus;
    int scanNum;
    boolean hasSelf;//是否是自己的
    *//*
    * 详情
    * *//*
    String questionId;
    String title;
    int allAnswerLikeNum;
    String createTime;
    String questionImage;
}*/

/*
@Data
class ShowQuestionAboutAnswerPoje{
    String answerId;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String authorImage;
    String authorName;
    int scanNum;
    boolean hasSelf;//是否是自己的
}
*/

@Data
class ShowAllQuestionByPageResult{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowAllQuestionByPagePojo{
    String questionId;
    String userId;
    String content;
    String title;
    int allAnswerLikeNum;
    String createTime;
    String questionImage;
    int scanNum;
    boolean hasSelf;//是否是自己的
}

@Data
class ShowQuestionByPage3Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowQuestionByPage3AboutQuestionPojo{
        String questionId;
        String userId;
        String title;
        String content;
        int allAnswerLikeNum;
        String createTime;
        String questionImage;
        boolean hasCollection;
        boolean hasFocus;
        int scanNum;
        boolean hasSelf;//是否是自己的
        String authorImage;
        String authorName;
}

@Data
class ShowQuestionByPage3AboutAnswerPojo{
        String answerId;
        String userId;
        String authorImage;
        String authorName;
        String content;
        String createTime;
        int likeNum;
        int unlikeNum;
        int commentNum;
        boolean hasLike;
        boolean hasCollection;
        boolean hasFocus;
        int scanNum;
        boolean hasSelf;//是否是自己的
}
