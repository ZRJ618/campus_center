package com.demo.controller;




import com.demo.exception.ResultBody;
import com.demo.pojo.*;
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
@RequestMapping("/collection2")
public class CollectionController2 {

    @Autowired
    CollectionAnswerService collectionAnswerService;
    @Autowired
    CollectionArticleService collectionArticleService;
    @Autowired
    CollectionQuestionService collectionQuestionService;
    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService1 userService1;


    /*
     * 分页查询:展示某人收藏的answer
     * */
    @GetMapping("/answer2/showByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showCollectionAnswerByPage2(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                  HttpServletRequest request){
        ShowCollectionAnswerByPage2Result result = new ShowCollectionAnswerByPage2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CollectionAnswer> collectionAnswers = collectionAnswerService.selectAllAnswerByUserIdByPage(userId,offSet,pageSize);
        for (int i = 0; i < collectionAnswers.size(); i++) {
            Answer answer = answerService.selectAnswerById(collectionAnswers.get(i).getAnswerId());
            //获取questionTitle
            String questionTitle = questionService.selectQuestion(answer.getQuestionId()).getTitle();
            //获取authorImage
            String authorImage = userService1.selectUserByUserId(answer.getUserId()).getSelfImage();
            //获取authorName
            String authorName = userService1.selectUserByUserId(answer.getUserId()).getUserName();
            //是否是自己的
            boolean hasSelf = false;
            if (answer.getUserId().equals(ParamUtil.getUserId(request))) {
                hasSelf = true;
            }else {
                hasSelf = false;
            }
            ShowCollectionAnswerByPage2Pojo pojo = setShowCollectionAnswerByPage2Pojo(answer.getAnswerId(),answer.getQuestionId(),answer.getContent(),
                    answer.getCreateTime(), answer.getLikeNum(),answer.getUnlikeNum(),answer.getCommentNum(),questionTitle,
                    authorImage,authorName,hasSelf,answer.getUserId());
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = collectionAnswerService.selectAllAnswerByUserId(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }

    /*
     * 分页查询:展示某人收藏的article
     * */
    @GetMapping("/article2/showByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showCollectionArticleByPage2(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                   HttpServletRequest request){
        ShowCollectionArticleByPage2Result result = new ShowCollectionArticleByPage2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CollectionArticle> collectionArticles = collectionArticleService.selectAllArticleByUserIdByPage(userId,offSet,pageSize);
        for (int i = 0; i < collectionArticles.size(); i++) {
            Article article = articleService.selectArticleById(collectionArticles.get(i).getArticleId());
            //获取authorImage
            String authorImage = userService1.selectUserByUserId(article.getUserId()).getSelfImage();
            //获取authorName
            String authorName = userService1.selectUserByUserId(article.getUserId()).getUserName();
            //是否是自己的
            boolean hasSelf = false;
            if (article.getUserId().equals(ParamUtil.getUserId(request))) {
                hasSelf = true;
            }else {
                hasSelf = false;
            }
            ShowCollectionArticleByPage2Pojo pojo = setShowCollectionArticleByPage2Pojo(article.getArticleId(),article.getTitle(),article.getContent(),article.getCreateTime(),article.getLikeNum(),
                    article.getUnlikeNum(),article.getCommentNum(),article.getArticleImage(),authorImage,authorName,hasSelf,article.getUserId());
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = collectionArticleService.selectAllArticleByUserId(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }


    /*
     * 分页查询:展示某人收藏的question
     * */
    @GetMapping("question2/showByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showCollectionQuestionByPage2(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                    HttpServletRequest request){
        ShowCollectionQuestionByPage2Result result = new ShowCollectionQuestionByPage2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CollectionQuestion> collentionQuestions = collectionQuestionService.selectAllQuestionByUserIdByPage(userId,offSet,pageSize);
        for (int i = 0; i < collentionQuestions.size(); i++) {
            Question question = questionService.selectQuestion(collentionQuestions.get(i).getQuestionId());
            ShowCollectionQuestionByPage2Pojo pojo = new ShowCollectionQuestionByPage2Pojo();
            pojo.setQuestionId(question.getQuestionId());
            pojo.setTitle(question.getTitle());
            pojo.setContent(question.getContent());
            pojo.setAllAnswerLikeNum(question.getAllAnswerLikeNum());
            pojo.setCreateTime(question.getCreateTime());
            pojo.setUserId(question.getUserId());
            //判断是否是自己的
            if (question.getUserId().equals(ParamUtil.getUserId(request))) {
                pojo.setHasSelf(true);
            }else {
                pojo.setHasSelf(false);
            }
            pojos.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = collectionQuestionService.selectAllQuestionByUserId(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }



    public ShowCollectionAnswerByPage2Pojo setShowCollectionAnswerByPage2Pojo(String answerId, String questionId, String content, String createTime,
                                                                                                       int likeNum, int unlikeNum, int commentNum, String questionTitle,
                                                                                                       String authorImage, String authorName, boolean hasSelf, String userId){
        ShowCollectionAnswerByPage2Pojo pojo = new ShowCollectionAnswerByPage2Pojo();
        pojo.setAnswerId(answerId);
        pojo.setQuestionId(questionId);
        pojo.setContent(content);
        pojo.setCreateTime(createTime);
        pojo.setLikeNum(likeNum);
        pojo.setUnlikeNum(unlikeNum);
        pojo.setCommentNum(commentNum);
        pojo.setQuestionTitle(questionTitle);
        pojo.setAuthorImage(authorImage);
        pojo.setAuthorName(authorName);
        pojo.setHasSelf(hasSelf);
        pojo.setUserId(userId);
        return pojo;
    }
    public ShowCollectionArticleByPage2Pojo setShowCollectionArticleByPage2Pojo(String articleId, String title, String content, String createTime,
                                                                                                         int likeNum, int unlikeNum, int commentNum, String articleImage,
                                                                                                         String authorImage, String authorName, boolean hasSelf, String userId){
        ShowCollectionArticleByPage2Pojo pojo = new ShowCollectionArticleByPage2Pojo();
        pojo.setArticleId(articleId);
        pojo.setTitle(title);
        pojo.setContent(content);
        pojo.setCreateTime(createTime);
        pojo.setLikeNum(likeNum);
        pojo.setUnlikeNum(unlikeNum);
        pojo.setCommentNum(commentNum);
        pojo.setArticleImage(articleImage);
        pojo.setAuthorImage(authorImage);
        pojo.setAuthorName(authorName);
        pojo.setHasSelf(hasSelf);
        pojo.setUserId(userId);
        return pojo;
    }
}

@Data
class ShowCollectionAnswerByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowCollectionAnswerByPage2Pojo{
    String answerId;
    String userId;
    String questionId;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String questionTitle;
    String authorImage;
    String authorName;
    boolean hasSelf;//是否是自己的
}


@Data
class ShowCollectionArticleByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class  ShowCollectionArticleByPage2Pojo{
    String articleId;
    String userId;
    String title;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String articleImage;
    String authorImage;
    String authorName;
    boolean hasSelf;//是否是自己的
}

@Data
class ShowCollectionQuestionByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowCollectionQuestionByPage2Pojo{
    String questionId;
    String userId;
    String title;
    String content;
    int allAnswerLikeNum;
    String createTime;
    boolean hasSelf;//是否是自己的
}
