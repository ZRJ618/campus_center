package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.CommentArticle;
import com.demo.pojo.CommentLike;
import com.demo.service.CommentArticleService;
import com.demo.service.CommentLikeService;
import com.demo.util.DateUtils;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/commentArticle")
public class CommentArticleController {
    @Autowired
    CommentArticleService service;

    @Autowired
    CommentLikeService commentLikeService;

    /*
     * 添加评论
     * */
    @PostMapping("/insert")
    public ResultBody insertComment(@RequestParam("articleId") String articleId, @RequestParam("content") String content, HttpServletRequest request) throws ParseException {
        String commentId = UUID.randomUUID().toString();
        String userId = ParamUtil.getUserId(request);
        String createTime = DateUtils.timestampToString(new Timestamp((new Date().getTime())));
        int likeNum = 0;
        int status = 1;
        //操作数据库
        service.insertComment(commentId,articleId,userId,content,createTime,likeNum,status);
        return ResultBody.success(commentId);
    }

    /*
     * 删除评论
     * */
    @PostMapping("/delete")
    public ResultBody deleteComment(@RequestParam("commentId") String commentId, HttpServletRequest request){
        //判断执行操作的是否是本人
        String userId = ParamUtil.getUserId(request);
        CommentArticle commentArticle = service.selectCommentById(commentId);
        if(!userId.equals(commentArticle.getUserId())){
            return ResultBody.exception500("不是本人操作");
        }
        service.updateStatus(commentId);
        return ResultBody.success();
    }

    /*
     * 查看某article的所有评论
     * */
    @GetMapping("/showAllComment/{articleId}")
    public ResultBody showAllComment(@PathVariable("articleId") String articleId){
        List<CommentArticle> commentAnswers = service.selectAllCommentByArticleId(articleId);
        return ResultBody.success(commentAnswers);
    }

    /*
     * 分页查询:查看某article的所有评论
     * */
    @GetMapping("/showAllCommentByPage/{articleId}/{pageNum}/{pageSize}")
    public ResultBody showAllCommentByPage(@PathVariable("articleId") String articleId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CommentArticle> commentAnswers = service.selectAllCommentByArticleByPage(articleId,offSet,pageSize);
        return ResultBody.success(commentAnswers);
    }

    /*
     * 为某评论点赞
     * */
    @PostMapping("/addLike")
    public ResultBody addLike(@RequestParam("commentId") String commentId, HttpServletRequest request){
        //检查是否已经点过赞了
        String userId = ParamUtil.getUserId(request);
        CommentLike commentLike = commentLikeService.selectByUserIdAndCommentId(userId,commentId);
        if(commentLike != null){
            return ResultBody.exception500("已经点过赞了");
        }
        //操作数据库
        CommentArticle commentArticle = service.selectCommentById(commentId);
        commentArticle.setLikeNum(commentArticle.getLikeNum() + 1);
        service.updateLikeNum(commentId,commentArticle.getLikeNum());
        commentLikeService.insertCommentLike(userId,commentId);
        return ResultBody.success();
    }
}
