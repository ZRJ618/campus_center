package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.pojo.Article;
import com.demo.pojo.CollectionArticle;
import com.demo.service.ArticleService;
import com.demo.service.CollectionArticleService;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collectionArticle")
public class CollectionArticleController {
    @Autowired
    CollectionArticleService service;

    @Autowired
    ArticleService articleService;


     /*
     * 收藏article
     * */
    @PostMapping("/insert")
    public ResultBody CollectionArticle(@RequestParam("articleId") String articleId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        //判断是否已经收藏过了
        CollectionArticle collectionArticle = service.selectArticleByUserIdAndArticleId(userId,articleId);
        if(collectionArticle != null){
            return ResultBody.exception500("已经收藏过了");
        }
        service.insertCollection(userId,articleId);
        return ResultBody.success();
    }

    /*
     * 判断是否已经收藏过了
     * */
    @PostMapping("/isCollection")
    public ResultBody isCollection(@RequestParam("articleId") String articleId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        CollectionArticle collectionArticle = service.selectArticleByUserIdAndArticleId(userId,articleId);
        if(collectionArticle != null){
            return new ResultBody("200","收藏过了",null);
        }else {
            return ResultBody.exception500("没有收藏过");
        }
    }


     /*
     * 删除收藏的article
     * */
    @PostMapping("/delete")
    public ResultBody deleteCollctionArticle(@RequestParam("articleId") String articleId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        service.updateStatus(userId,articleId);
        return ResultBody.success();
    }

    /*
    * 展示某人收藏的article
    * */
    @GetMapping("/show/{userId}")
    public ResultBody showCollectionArticle(@PathVariable("userId") String userId){
        List<CollectionArticle> collectionArticles = service.selectAllArticleByUserId(userId);
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < collectionArticles.size(); i++) {
            Article article = articleService.selectArticleById(collectionArticles.get(i).getArticleId());
            articles.add(article);
        }
        return ResultBody.success(articles);
    }

    /*
     * 分页查询:展示某人收藏的article
     * 已弃用
     * */
/*    @GetMapping("/showByPage/{userId}/{pageNum}/{pageSize}")
    public ResultBody showCollectionArticleByPage(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<CollectionArticle> collectionArticles = service.selectAllArticleByUserIdByPage(userId,offSet,pageSize);
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < collectionArticles.size(); i++) {
            Article article = articleService.selectArticleById(collectionArticles.get(i).getArticleId());
            articles.add(article);
        }
        return ResultBody.success(articles);
    }*/
}
