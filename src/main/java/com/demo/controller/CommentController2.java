package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.CommentAnswer;
import com.demo.pojo.CommentArticle;
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
import org.w3c.dom.html.HTMLHtmlElement;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/comment2")
public class CommentController2 {
    @Autowired
    CommentAnswerService commentAnswerService;
    @Autowired
    CommentArticleService commentArticleService;
    @Autowired
    CommentLikeService commentLikeService;
    @Autowired
    UserService1 userService1;


    /*
     * 分页查询:查看某answer的所有评论
     * */
    @GetMapping("/showAnswerAllCommentByPage2/{answerId}/{pageNum}/{pageSize}")
    public ResultBody showAnswerAllCommentByPage2(@PathVariable("answerId") String answerId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                  HttpServletRequest request){
        ShowAnswerAllCommentByPage2Result result = new ShowAnswerAllCommentByPage2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CommentAnswer> commentAnswers = commentAnswerService.selectAllCommentByAnswerIdByPage(answerId,offSet,pageSize);
        commentAnswers.forEach(commentAnswer -> {
            //获取authorImage
            String authorImage = userService1.selectUserByUserId(commentAnswer.getUserId()).getSelfImage();
            //获取authorName
            String authorName = userService1.selectUserByUserId(commentAnswer.getUserId()).getUserName();
            //是否是自己的
            boolean hasSelf = false;
            if (commentAnswer.getUserId().equals(ParamUtil.getUserId(request))) {
                hasSelf = true;
            }else {
                hasSelf = false;
            }
            //是否点赞
            boolean hasLike = false;
            if (commentAnswer.getUserId().equals(ParamUtil.getUserId(request))) {
                hasLike = true;
            }else {
                hasLike = false;
            }
            ShowAnswerAllCommentByPage2Pojo pojo = setShowAnswerAllCommentByPage2Pojo(commentAnswer.getCommentId(),commentAnswer.getUserId(),commentAnswer.getContent(),
                    commentAnswer.getCreateTime(),commentAnswer.getLikeNum(),authorImage,authorName,hasSelf,answerId,hasLike);
            pojos.add(pojo);

        });
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = commentAnswerService.selectAllCommentByAnswerId(answerId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }

    /*
     * 分页查询:查看某article的所有评论
     * */
    @GetMapping("/showArticleAllCommentByPage2/{articleId}/{pageNum}/{pageSize}")
    public ResultBody showArticleAllCommentByPage2(@PathVariable("articleId") String articleId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                                                   HttpServletRequest request){
        ShowArticleAllCommentByPage2Result result = new ShowArticleAllCommentByPage2Result();
        List<Object> pojos = new ArrayList<>();
        //设置分页
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CommentArticle> commentArticles = commentArticleService.selectAllCommentByArticleByPage(articleId,offSet,pageSize);
        commentArticles.forEach(commentArticle -> {
            //获取authorImage
            String authorImage = userService1.selectUserByUserId(commentArticle.getUserId()).getSelfImage();
            //获取authorName
            String authorName = userService1.selectUserByUserId(commentArticle.getUserId()).getUserName();
            //是否是自己的
            boolean hasSelf = false;
            if (commentArticle.getUserId().equals(ParamUtil.getUserId(request))) {
                hasSelf = true;
            }else {
                hasSelf = false;
            }
            //是否点赞
            boolean hasLike = false;
            if (commentArticle.getUserId().equals(ParamUtil.getUserId(request))) {
                hasLike = true;
            }else {
                hasLike = false;
            }
            ShowArticleAllCommentByPage2Pojo pojo = setShowArticleAllCommentByPage2Pojo(commentArticle.getCommentId(),commentArticle.getUserId(),commentArticle.getContent(),
                    commentArticle.getCreateTime(),commentArticle.getLikeNum(),authorImage,authorName,hasSelf,articleId,hasLike);
            pojos.add(pojo);
        });
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = commentArticleService.selectAllCommentByArticleId(articleId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojos;
        return ResultBody.success(result);
    }

    public ShowAnswerAllCommentByPage2Pojo setShowAnswerAllCommentByPage2Pojo(String commentId, String userId, String content, String createTime,
                                                                              int likeNum, String authorImage, String authorName, boolean hasSelf,
                                                                              String answerId,boolean hasLike){
        ShowAnswerAllCommentByPage2Pojo pojo = new ShowAnswerAllCommentByPage2Pojo();
        pojo.setCommentId(commentId);
        pojo.setUserId(userId);
        pojo.setContent(content);
        pojo.setCreateTime(createTime);
        pojo.setLikeNum(likeNum);
        pojo.setAuthorImage(authorImage);
        pojo.setAuthorName(authorName);
        pojo.setHasSelf(hasSelf);
        pojo.setAnswerId(answerId);
        pojo.setHasLike(hasLike);
        return pojo;
    }

    public ShowArticleAllCommentByPage2Pojo setShowArticleAllCommentByPage2Pojo(String commentId, String userId, String content, String createTime,
                                                                                int likeNum, String authorImage, String authorName,
                                                                                boolean hasSelf, String articleId,boolean hasLike){
        ShowArticleAllCommentByPage2Pojo pojo = new ShowArticleAllCommentByPage2Pojo();
        pojo.setCommentId(commentId);
        pojo.setUserId(userId);
        pojo.setContent(content);
        pojo.setCreateTime(createTime);
        pojo.setLikeNum(likeNum);
        pojo.setAuthorImage(authorImage);
        pojo.setAuthorName(authorName);
        pojo.setHasSelf(hasSelf);
        pojo.setArticleId(articleId);
        pojo.setHasLike(hasLike);
        return pojo;
    }
}


@Data
class ShowAnswerAllCommentByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowAnswerAllCommentByPage2Pojo{
    String commentId;
    String answerId;
    String userId;
    String content;
    String createTime;
    int likeNum;
    String authorImage;
    String authorName;
    boolean hasSelf;//是否是自己的
    boolean hasLike;//是否点赞
}


@Data
class ShowArticleAllCommentByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowArticleAllCommentByPage2Pojo{
    String commentId;
    String articleId;
    String userId;
    String content;
    String createTime;
    int likeNum;
    String authorImage;
    String authorName;
    boolean hasSelf;//是否是自己的
    boolean hasLike;//是否点赞
}
