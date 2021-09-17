package com.demo.controller;


import com.demo.exception.ResultBody;
import com.demo.exception.SelfDefindException;
import com.demo.pojo.Answer;
import com.demo.pojo.Question;
import com.demo.service.AnswerService;
import com.demo.service.LabelService;
import com.demo.service.QuestionService;
import com.demo.util.PageUtils;
import com.demo.util.ParamUtil;
import com.demo.util.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @Autowired
    LabelService labelService;

    @Autowired
    AnswerService answerService;


    /*
     * 上传图片并返回图片的RRL
     * */
    @PostMapping("/uploadQuestionImage")
    public ResultBody uploadQuestionImage(@RequestParam("multipartFile") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String imageURI = UploadImage.uploacImage(multipartFile,"/static/questionImage/");
        String imageURL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+imageURI;
        return ResultBody.success(imageURL);
    }

    /*
     * 上传question，并为question添加label,并返回questionId（固定label为四个）
     * */
    @PostMapping("/uploadQuestion")
    public ResultBody uploadQuestion(@RequestParam("title") String title, @RequestParam("content") String content,
                                     String questionImage,
                                     @RequestParam("label1") String label1, @RequestParam("label2") String label2,
                                     @RequestParam("label3") String label3, @RequestParam("label4") String label4, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        String questionId = UUID.randomUUID().toString();
        Timestamp createTime = new Timestamp(new Date().getTime());
        int status = 1;
        //操作数据库
        questionService.insertQuestion(title,content,userId,questionId,createTime,questionImage,status);
        //为question添加label
        updateQuestionLabel(questionId,label1,label2,label3,label4);
        return ResultBody.success(questionId);
    }

    /*
     * 上传question，并为question添加label,并返回questionId（使用数组传递label）
     * */
/*    @PostMapping("/uploadQuestionUseArray")
    public ResultBody uploadQuestion2(@RequestParam("title") String title, @RequestParam("content") String content,
                                      String questionImage, String[] label, HttpServletRequest request){
        String userId = ParamUtil.getUserId(request);
        String questionId = UUID.randomUUID().toString();
        Timestamp createTime = new Timestamp(new Date().getTime());
        int status = 1;
        //操作数据库
        questionService.insertQuestion(title,content,userId,questionId,createTime,questionImage,status);
        //为question添加label
        if(label.length > 0){
            updateQuestionLabel2(questionId,label);
        }
        return ResultBody.success(questionId);
    }*/

    /*
     * 修改question:标题、内容、标签、封面（固定四个label）
     * */
    @PostMapping("fixQuestion")
    public ResultBody fixQuestion(@RequestParam("questionId") String questionId, @RequestParam("title") String title, @RequestParam("content") String content,
                                  @RequestParam String questionImage,
                                  @RequestParam("label1") String label1, @RequestParam("label2") String label2,
                                  @RequestParam("label3") String label3, @RequestParam("label4") String label4, HttpServletRequest request) throws IOException {
        questionService.updateQuestion(questionId,title,content,questionImage);
        updateQuestionLabel(questionId,label1,label2,label3,label4);
        return ResultBody.success();
    }

    /*
     * 修改question:标题、内容、标签、封面(使用数组传递label)
     * */
/*    @PostMapping("fixQuestionUseArray")
    public ResultBody fixQuestion2(@RequestParam("questionId") String questionId, @RequestParam("title") String title, @RequestParam("content") String content,
                                   @RequestParam String questionImage,
                                   String[] label, HttpServletRequest request) throws IOException {
        questionService.updateQuestion(questionId,title,content,questionImage);
        if(label.length > 0){
            updateQuestionLabel2(questionId,label);
        }
        return ResultBody.success();
    }*/


    /*
    * 展示一个question（该question及它所有的answer）
    * 已弃用
    * */
/*    @GetMapping("/showQuestion/{questionId}")
    public ResultBody showQuestion(@PathVariable("questionId") String questionId, HttpServletRequest request){
        Question question = questionService.selectQuestion(questionId);
        //判断该question是否存在
        if(question == null){
            throw new SelfDefindException("500","该question已被删除",null);
        }
        //将该question的浏览量加一
        question.setScanNum(question.getScanNum()+1);
        questionService.updateAllAnswerScanNum(question.getScanNum(),question.getQuestionId());
        //创建objects
        List<Object> objects = new ArrayList<>();
        objects.add(question);
        //查找其所有的回答
        List<Answer> answers = answerService.selectAllAnswerByQuestionId(questionId);
        objects.add(answers);
        return ResultBody.success(objects);
    }*/


    /*
    * 分页展示某个question的所有回答（包含question本身）
    * 已弃用
    * */
/*    @GetMapping("/showQuestionByPage/{questionId}/{pageNum}/{pageSize}")
    public ResultBody showQuestionByPage(@PathVariable("questionId") String questionId, @PathVariable("pageNum") int pageNum,
                                         @PathVariable("pageSize") int pageSize, HttpServletRequest request){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        //获取question
        Question question = questionService.selectQuestion(questionId);
        //判断该question是否存在
        if(question == null){
            throw new SelfDefindException("500","该question已被删除",null);
        }
        List<Object> objects = new ArrayList<>();
        objects.add(question);
        //分页查找其回答
        List<Answer> answers = answerService.selectAllAnswerByQuestionIdByPage(questionId,offSet,pageSize);
        objects.add(answers);
        return ResultBody.success(objects);
    }*/


    /*
     * 删除某篇question
     * */
    @PostMapping("/deleteQuestion")
    public ResultBody deleteQuestion(@RequestParam("questionId") String questionId){
        questionService.deleteQuestion(questionId);
        return ResultBody.success();
    }

    /*
     * 粗略展示某人的所有question
     * */
    @GetMapping("/showAllQuestion/{userId}")
    public ResultBody showAllQuestion(@PathVariable String userId){
        List<Question> questionList = questionService.selectAllQuestionByUserId(userId);
        return ResultBody.success(questionList);
    }

    /*
     * 分页查询:粗略展示某人的所有question
     * 已弃用
     * */
/*    @GetMapping("/showAllQuestionByPage/{userId}/{pageNum}/{pageSize}")
    public ResultBody showAllQuestionByPage(@PathVariable String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        int offSet = PageUtils.pageUtils(pageNum,pageSize);
        List<Question> questionList = questionService.selectAllQuestionByUserIdByPage(userId,offSet,pageSize);
        return ResultBody.success(questionList);
    }*/



    /*
     * 修改指定question的label
     * 删除该questionId下所有的label
     * 再添加该question的新label
     * */
    private void updateQuestionLabel(String QuestionId,String label1, String label2, String label3,String label4){
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
        //删除该QuestionId下所有的label
        questionService.deleteQuestionLabel(QuestionId);
        //添加该article的新label
        if(label11 != -1){
            questionService.insertQuestionLabel(QuestionId,label11);
        }
        if(label22 != -1){
            questionService.insertQuestionLabel(QuestionId,label22);
        }
        if(label33 != -1){
            questionService.insertQuestionLabel(QuestionId,label33);
        }
        if(label44 != -1){
            questionService.insertQuestionLabel(QuestionId,label44);
        }
    }


    /*
     * 修改指定question的label:（使用数组传递label）
     *      删除该question下所有的label
     *      再添加该question的新label
     * */
/*    private void updateQuestionLabel2(String articleId,String[] label){
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
        questionService.deleteQuestionLabel(articleId);
        //添加该article的新label
        for (int i = 0; i < list.size(); i++) {
            questionService.insertQuestionLabel(articleId,list.get(i));
        }
    }*/
}
