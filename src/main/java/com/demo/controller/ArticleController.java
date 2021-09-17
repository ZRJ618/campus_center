package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.exception.SelfDefindException;
import com.demo.pojo.Article;
import com.demo.pojo.ArticleLike;
import com.demo.service.*;
import com.demo.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    LabelService labelService;

    @Autowired
    ArticleLabelService articleLabelService;

    @Autowired
    ArticleLikeService articleLikeService;

    @Autowired
    ScanHistoryService scanHistoryService;

    /*
    * 上传图片并返回图片的RRL(用于编辑文章时插入图片)
    * */
    @PostMapping("/uploadArticleImage")
    public ResultBody uploadArticleImage(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String imageURI = UploadImage.uploacImage(multipartFile,"/static/articleImage/");
        String imageURL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+imageURI;
        return ResultBody.success(imageURL);
    }

    /*
    * 上传文章，并为文章添加label,并返回articleId（固定四个label）
    * articleCover是封面
    * */
    @PostMapping("/uploadArticle")
    public ResultBody uploadArticle(@RequestParam("title") String title, @RequestParam("content") String content, MultipartFile articleCover,
                                    @RequestParam("label1") String label1, @RequestParam("label2") String label2,
                                    @RequestParam("label3") String label3, @RequestParam("label4") String label4, HttpServletRequest request) throws IOException {
        String articleId = UUID.randomUUID().toString();
        String userId = ParamUtil.getUserId(request);
        Timestamp createTime = new Timestamp(new Date().getTime());
        String articleImage = null;
        int likeNum = 0;
        int unlikeNum = 0;
        int commentNum = 0;
        int status = 1;
        //判断articleCover（封面）是否为null，若为null，则articleImage为null，若不为null，则为articleImage赋值URl
        if(articleCover != null){
            String articleCoverURI = UploadImage.uploacImage(articleCover,"/static/articleCover/");
            articleImage = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+articleCoverURI;
        }
        //操作数据库
        articleService.insertArticle(articleId,userId,title,content,createTime,likeNum,unlikeNum,commentNum,articleImage,status);
        //为该article添加label（注意该操作需在操作数据库之后）
        updateArticleLabel(articleId,label1,label2,label3,label4);
        return ResultBody.success(articleId);
    }


    /*
     * 上传文章，并为文章添加label,并返回articleId（使用数组传递label）
     * articleCover是封面
     * */
/*    @PostMapping("/uploadArticleUseArray")
    public ResultBody uploadArticle2(@RequestParam("title") String title, @RequestParam("content") String content, MultipartFile articleCover,
                                     String[] label, HttpServletRequest request) throws IOException {
        String articleId = UUID.randomUUID().toString();
        String userId = ParamUtil.getUserId(request);
        Timestamp createTime = new Timestamp(new Date().getTime());
        String articleImage = null;
        int likeNum = 0;
        int unlikeNum = 0;
        int commentNum = 0;
        int status = 1;
        //判断articleCover（封面）是否为null，若为null，则articleImage为null，若不为null，则为articleImage赋值URl
        if(articleCover != null){
            String articleCoverURI = UploadImage.uploacImage(articleCover,"/static/articleCover/");
            articleImage = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+articleCoverURI;
        }
        //操作数据库
        articleService.insertArticle(articleId,userId,title,content,createTime,likeNum,unlikeNum,commentNum,articleImage,status);
        //为该article添加label（注意该操作需在操作数据库之后）
        if (label.length > 0){
            updateArticleLabel2(articleId,label);
        }
        return ResultBody.success(articleId);
    }*/

    /*
    * 修改文章:标题、内容、封面、标签（固定四个label）
    * */
    @PostMapping("fixArticle")
    public ResultBody fixArticle(@RequestParam("articleId") String articleId, @RequestParam("title") String title, @RequestParam("content") String content,
                                 MultipartFile articleCover, @RequestParam("label1") String label1, @RequestParam("label2") String label2,
                                 @RequestParam("label3") String label3, @RequestParam("label4") String label4, HttpServletRequest request) throws IOException {
        String articleImage = null;
        if(articleCover != null){
            articleImage  = UploadImage.uploacImage(articleCover,"/static/articleCover/",request);
        }
        articleService.updateArticle(articleId,title,content,articleImage);
        updateArticleLabel(articleId,label1,label2,label3,label4);
        return ResultBody.success();
    }

    /*
     * 修改文章:标题、内容、封面、标签（使用数组传递label）
     * */
/*    @PostMapping("fixArticleUseArray")
    public ResultBody fixArticle2(@RequestParam("articleId") String articleId, @RequestParam("title") String title, @RequestParam("content") String content,
                                  MultipartFile articleCover, String[] label, HttpServletRequest request) throws IOException {
        String articleImage = null;
        if(articleCover != null){
            articleImage  = UploadImage.uploacImage(articleCover,"/static/articleCover/",request);
        }
        articleService.updateArticle(articleId,title,content,articleImage);
        if(label.length > 0){
            updateArticleLabel2(articleId,label);
        }
        return ResultBody.success();
    }*/

    /*
     * 详细展示某篇文章(articleId,Get请求)
     * 已弃用
     * */
/*    @GetMapping("/showArticle/{articleId}")
    public ResultBody showArticle(@PathVariable String articleId, HttpServletRequest request) throws ParseException {
        Article article1 = articleService.selectArticleById(articleId);
        //添加浏览记录
        String selfId = ParamUtil.getUserId(request);
        String scanHistoryId = UUID.randomUUID().toString();
        String createTime = DateUtils.timestampToString(new Timestamp(new Date().getTime()));
        scanHistoryService.insertScanHistory(scanHistoryId,selfId,articleId,createTime);
        //该article的浏览量加一
        article1.setScanNum(article1.getScanNum()+1);
        articleService.updateScanNum(article1.getScanNum(),article1.getArticleId());
        return ResultBody.success(article1);
    }*/

    /*
    * 显示某篇文章的所有标签
    * */
    @GetMapping("/showArticleLabel/{articleId}")
    public ResultBody showArticleLabel(@PathVariable String articleId){
        List<Integer> list = articleLabelService.selectLabelByArticle(articleId);
        List<String> listLabel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listLabel.add(labelService.selectLabel(list.get(i)));
        }
        return ResultBody.success(listLabel);
    }

    /*
    * 删除某篇article
    * */
    @PostMapping("/deleteArticle")
    public ResultBody deleteArticle(@RequestParam("articleId") String articleId, HttpServletRequest request){
        articleService.deleteArticle(articleId);
        return ResultBody.success();
    }

    /*
    * 为某篇article点赞
    * */
    @PostMapping("/likeArticle")
    public ResultBody likeArticle(@RequestParam("articleId") String articleId, HttpServletRequest request){
        Article article = articleService.selectArticleById(articleId);
        if(article == null){
            return ResultBody.exception500("该article不存在");
        }
        //判断是否已经为该article点过赞了
        String userId = ParamUtil.getUserId(request);
        ArticleLike articleLike = articleLikeService.selectByUserIdAndArticleId(userId,articleId);
        if(articleLike != null){
            return ResultBody.exception500("已经点过赞了");
        }
        //操作数据库
        article.setLikeNum(article.getLikeNum() + 1);
        articleService.updateLikeNum(article.getLikeNum(),articleId);
        articleLikeService.insertArticleLike(userId,articleId);
        return ResultBody.success();
    }


    /*
    * 取消点赞
    * */
    @PostMapping("/cancelLikeArticle")
    public ResultBody cancelLikeArticle(@RequestParam("articleId") String articleId, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        Article article = articleService.selectArticleById(articleId);
        //判断是否已经为该article点过赞了
        ArticleLike articleLike = articleLikeService.selectByUserIdAndArticleId(userId,articleId);
        if(articleLike == null){
            return ResultBody.exception500("没有对其进行点赞，无法取消点赞");
        }
        //操作数据库
        article.setLikeNum(article.getLikeNum() - 1);
        articleService.updateLikeNum(article.getLikeNum(),articleId);
        articleLikeService.deleteArticleLike(userId,articleId);
        return ResultBody.success();
    }


    /*
    * 看是否为某article点过赞
    * */
    @PostMapping("/isLikeArticle")
    public ResultBody isLikeArticle(@RequestParam("articleId") String articleId, HttpServletRequest request) {
        String userId = ParamUtil.getUserId(request);
        //判断是否已经为该article点过赞了
        ArticleLike articleLike = articleLikeService.selectByUserIdAndArticleId(userId, articleId);
        if (articleLike != null) {
            return new ResultBody("200", "点过赞了", null);
        } else {
            return ResultBody.exception500("没有点过赞");
        }
    }


    /*
    * 粗略展示某人的所有文章
    * */
    @GetMapping("/showAllArticle/{userId}")
    public ResultBody showAllArticle(@PathVariable String userId){
        List<Article> articleList = articleService.selectAllArticle(userId);
        return ResultBody.success(articleList);
    }

    /*
     * 分页查询:粗略展示某人的所有文章
     * 已弃用
     * */
/*    @GetMapping("/showAllArticleByPage/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllArticleByPage(@PathVariable String userId, @PathVariable int pageNum, @PathVariable int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<Article> articleList = articleService.selectAllArticleByPage(userId,offSet,pageSize);
        return ResultBody.success(articleList);
    }*/


    /*
    * 修改指定article的label：(固定四个label)
    *   删除该articleId下所有的label
    *   再添加该article的新label
    * */
    private void updateArticleLabel(String articleId,String label1, String label2, String label3,String label4){
        Integer label11 = -1,label22 = -1,label33 = -1,label44 = -1;
        //查询label的自增id
        if (!label1.equals("")){
             label11 = labelService.selectSelfAdd(label1);
        }

        if (!label2.equals("")){
             label22 = labelService.selectSelfAdd(label2);
        }
        if (!label3.equals("")){
             label33 = labelService.selectSelfAdd(label3);
        }
        if (!label4.equals("")){
             label44 = labelService.selectSelfAdd(label4);
        }
        //若没查到自增id，则抛出异常
        if(label11 == null | label22 == null | label33 == null | label44 == null){
            throw new SelfDefindException("500","label值错误",null);
        }
        //删除该articleId下所有的label
        articleService.deleteArticleLabel(articleId);
        //添加该article的新label
        if(label11 != -1){
            articleService.insertArticleLabel(articleId,label11);
        }
        if(label22 != -1){
            articleService.insertArticleLabel(articleId,label22);
        }
        if(label33 != -1){
            articleService.insertArticleLabel(articleId,label33);
        }
        if(label44 != -1){
            articleService.insertArticleLabel(articleId,label44);
        }
    }

    /*
     * 修改指定article的label:（使用数组传递label）
     *      删除该articleId下所有的label
     *      再添加该article的新label
     * */
/*    private void updateArticleLabel2(String articleId,String[] label){
        //是否有重复，或空字符串
        Set<String> set = new HashSet<>();
        for (int i = 0; i < label.length; i++) {
            if(label[i].equals("")){
                //throw new SelfDefindException("500","label值不能为空",null);
                continue;
            }
            set.add(label[i]);
        }
        //检查label是否存在,若存在则取出该label的id
        String[] strings = set.toArray(new String[set.size()]);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            Integer number = labelService.selectSelfAdd(strings[i]);
            if(number == null){
                throw new SelfDefindException("500","label值不存在",null);
            }
            list.add(number);
        }
        //删除该articleId下所有的label
        articleService.deleteArticleLabel(articleId);
        //添加该article的新label
        for (int i = 0; i < list.size(); i++) {
            articleService.insertArticleLabel(articleId,list.get(i));
        }
    }*/
}
