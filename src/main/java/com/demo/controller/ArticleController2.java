package com.demo.controller;

import com.demo.exception.ResultBody;
import com.demo.pojo.*;
import com.demo.pojo.user.User;
import com.demo.service.*;
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
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController2 {
    @Autowired
    ArticleService articleService;
    @Autowired
    LabelService labelService;
    @Autowired
    ArticleLabelService articleLabelService;
    @Autowired
    ArticleLikeService articleLikeService;
    @Autowired
    FansService fansService;
    @Autowired
    CollectionArticleService service;
    @Autowired
    UserService1 userService1;
    @Autowired
    ScanHistoryService scanHistoryService;


    /*
    * 详细展示某篇文章(articleId,Get请求)
    * */
    @GetMapping("/showArticle2/{articleId}")
    public ResultBody showArticle(@PathVariable String articleId, HttpServletRequest request) throws ParseException {
        ShowArticle2Pojo showArticle2Pojo = new ShowArticle2Pojo();
        //获取该article
        Article article = articleService.selectArticleById(articleId);
        showArticle2Pojo.setUserId(article.getUserId());
        //获取作者头像与名字
        User user = userService1.selectUserByUserId(article.getUserId());
        showArticle2Pojo.setUserImage(user.getSelfImage());
        showArticle2Pojo.setUserName(user.getUserName());
        //是否关注过
        String selfId = ParamUtil.getUserId(request);
        Fans fans = fansService.selectByUserIdAndFansId(article.getUserId(),selfId);
        if(fans == null){
            showArticle2Pojo.setHasFocus(false);
        }else {
            showArticle2Pojo.setHasFocus(true);
        }
        //是否是自己的
        if (article.getUserId().equals(ParamUtil.getUserId(request))) {
            showArticle2Pojo.setHasSelf(true);
        }else {
            showArticle2Pojo.setHasSelf(false);
        }
        //是否收藏过
        CollectionArticle collectionArticle = service.selectArticleByUserIdAndArticleId(selfId,articleId);
        if(collectionArticle != null){
           showArticle2Pojo.setHascollection(true);
        }else {
            showArticle2Pojo.setHascollection(false);
        }
        //是否点赞
        ArticleLike articleLike = articleLikeService.selectByUserIdAndArticleId(selfId, articleId);
        if (articleLike != null) {
            showArticle2Pojo.setHasLike(true);
        } else {
            showArticle2Pojo.setHasLike(false);
        }
        //该article的所有标签
        List<Integer> list = articleLabelService.selectLabelByArticle(articleId);
        List<String> listLabel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listLabel.add(labelService.selectLabel(list.get(i)));
        }
        showArticle2Pojo.setLabel(listLabel);
        //添加浏览记录
        String scanHistoryId = UUID.randomUUID().toString();
        String createTime = DateUtils.timestampToString(new Timestamp(new Date().getTime()));
        scanHistoryService.insertScanHistory(scanHistoryId,selfId,articleId,createTime);
        //该article的浏览量加一
        article.setScanNum(article.getScanNum()+1);
        articleService.updateScanNum(article.getScanNum(),article.getArticleId());
        //为showArticle2Pojo添加scanNum
        showArticle2Pojo.setScanNum(article.getScanNum());
        //为showArticle2Pojo添加article的详细信息
        setShowArticle2Pojo(showArticle2Pojo,article.getArticleId(), article.getTitle(), article.getContent(), article.getCreateTime(),
                article.getLikeNum(), article.getUnlikeNum(), article.getCommentNum(), article.getArticleImage());
        return ResultBody.success(showArticle2Pojo);
    }

    /*
     * 分页查询:粗略展示某人的所有文章
     * */
    @GetMapping("/showAllArticleByPage2/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllArticleByPage(@PathVariable String userId, @PathVariable int pageNum, @PathVariable int pageSize,
                                           HttpServletRequest request){
        ShowAllArticleByPage2Result result = new ShowAllArticleByPage2Result();
        List<Object> pojoList = new ArrayList<>();
        //分页调用
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        //查找articleList
        List<Article> articleList = articleService.selectAllArticleByPage(userId,offSet,pageSize);
        //为pojoList赋值
        for (int i = 0; i < articleList.size(); i++) {
            ShowAllArticleByPage2Pojo pojo = new ShowAllArticleByPage2Pojo();
            pojo.setUserId(ParamUtil.getUserId(request));
            pojo.setArticleId(articleList.get(i).getArticleId());
            pojo.setTitle(articleList.get(i).getTitle());
            pojo.setContent(articleList.get(i).getContent());
            pojo.setCreateTime(articleList.get(i).getCreateTime());
            pojo.setLikeNum(articleList.get(i).getLikeNum());
            pojo.setUnlikeNum(articleList.get(i).getUnlikeNum());
            pojo.setCommentNum(articleList.get(i).getCommentNum());
            pojo.setArticleImage(articleList.get(i).getArticleImage());
            pojo.setScanNum(articleList.get(i).getScanNum());
            //判断是否是自己的
            if (articleList.get(i).getUserId().equals(ParamUtil.getUserId(request))) {
                pojo.setHasSelf(true);
            }else {
                pojo.setHasSelf(false);
            }
            //获取该article的作者的头像
            User author = userService1.selectUserByUserId(articleList.get(i).getUserId());
            pojo.setAuthorImage(author.getSelfImage());
            //获取该article的作者的名字
            pojo.setAuthorName(author.getUserName());
            pojoList.add(pojo);
        }
        //添加三天之内所有数据的总条数与所有的页面数
        int allDataNum = articleService.selectAllArticle(userId).size();
        double allPageNum = Math.ceil((double) allDataNum / (double) pageSize);
        result.allDataNum = allDataNum;
        result.allPageNum = (int) allPageNum;
        result.data = pojoList;
        return ResultBody.success(result);
    }

    public void setShowArticle2Pojo(ShowArticle2Pojo pojo, String articleId, String title, String content, String createTime,
                                                int likeNum, int unlikeNum, int commentNum, String articleImage){
        pojo.setArticleId(articleId);
        pojo.setTitle(title);
        pojo.setContent(content);
        pojo.setCreateTime(createTime);
        pojo.setLikeNum(likeNum);
        pojo.setUnlikeNum(unlikeNum);
        pojo.setCommentNum(commentNum);
        pojo.setArticleImage(articleImage);
    }

    /*
     * 随机展示30条文章
     * */
    @GetMapping("/showRandomArticle")
    public ResultBody showRandomArticle(HttpServletRequest request){
        final int SUM = 30;
        List<Object> objects = new ArrayList<>();
        //查询所有的articleId
        List<String> wholeArticleIdList = articleService.selectWholeArticleId();
        if(wholeArticleIdList.size() == 0){
            return ResultBody.success();
        }
        if (wholeArticleIdList.size() <= SUM) {
            //打乱顺序
            Collections.shuffle(wholeArticleIdList);
            //查询set中的article
            wholeArticleIdList.forEach(s -> {
                Article article = articleService.selectArticleById(s);
                ShowRandomArticlePojo pojo = new ShowRandomArticlePojo();
                //获取该article的作者
                User user = userService1.selectUserByUserId(article.getUserId());
                //为pojo赋值
                pojo.setUserId(article.getUserId());
                pojo.setUserImage(user.getSelfImage());
                pojo.setUserName(user.getUserName());
                pojo.setScanNum(article.getScanNum());
                pojo.setArticleId(article.getArticleId());
                pojo.setTitle(article.getTitle());
                pojo.setContent(article.getContent());
                pojo.setCreateTime(article.getCreateTime());
                pojo.setLikeNum(article.getLikeNum());
                pojo.setUnlikeNum(article.getUnlikeNum());
                pojo.setArticleImage(article.getArticleImage());
                objects.add(pojo);
            });
            return ResultBody.success(objects);
        }else if(wholeArticleIdList.size() > SUM){
            //随机抽取SUM条articleId
            Set<String> set = new HashSet<>();
            for (int i = 0; i < SUM; i++) {
                for (;;){
                    int randomValue = (int) (0 + Math.random() * ((wholeArticleIdList.size() - 1) - 0 + 1));
                    int setSize = set.size();
                    set.add(wholeArticleIdList.get(randomValue));
                    if(set.size() > setSize)
                        break;
                }
            }
            //查询set中的article
            List<String> list = new ArrayList<>(set);
            list.forEach(s -> {
                Article article = articleService.selectArticleById(s);
                ShowRandomArticlePojo pojo = new ShowRandomArticlePojo();
                //获取该article的作者
                User user = userService1.selectUserByUserId(article.getUserId());
                //为pojo赋值
                pojo.setUserId(article.getUserId());
                pojo.setUserImage(user.getSelfImage());
                pojo.setUserName(user.getUserName());
                pojo.setScanNum(article.getScanNum());
                pojo.setArticleId(article.getArticleId());
                pojo.setTitle(article.getTitle());
                pojo.setContent(article.getContent());
                pojo.setCreateTime(article.getCreateTime());
                pojo.setLikeNum(article.getLikeNum());
                pojo.setUnlikeNum(article.getUnlikeNum());
                pojo.setArticleImage(article.getArticleImage());
                objects.add(pojo);
            });
            return ResultBody.success(objects);
        }
        return ResultBody.exception500("程序错误");
    }
}

@Data
class ShowArticle2Pojo{
    String userId;   //作者Id
    String userImage;//作者头像
    String userName;//作者名
    boolean hasFocus;  //是否关注作者
    boolean hascollection;    //是否收藏
    boolean hasLike;   //是否点赞
    int scanNum;//浏览量
    List<String> label;  //该article的所有标签
    boolean hasSelf;//是否是自己的
    /*
    * 以下添加该article的详细信息
    * */
    String articleId;
    String title;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String articleImage;
}



@Data
class ShowAllArticleByPage2Result{
    int allDataNum;
    int allPageNum;
    List<Object> data;
}

@Data
class ShowAllArticleByPage2Pojo{
    String userId;//作者id
    String articleId;
    String title;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    int commentNum;
    String articleImage;
    String authorImage;
    String authorName;
    int scanNum;//浏览量
    boolean hasSelf;//是否是自己的
}

@Data
class ShowRandomArticlePojo{
    String userId;   //作者Id
    String userImage;//作者头像
    String userName;//作者名
    int scanNum;//浏览量
    /*
     * 以下添加该article的详细信息
     * */
    String articleId;
    String title;
    String content;
    String createTime;
    int likeNum;
    int unlikeNum;
    String articleImage;
}
