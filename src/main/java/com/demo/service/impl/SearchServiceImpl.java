package com.demo.service.impl;

import com.demo.mapper.AnswerMapper;
import com.demo.mapper.QuestionMapper;
import com.demo.mapper.UserMapper;
import com.demo.pojo.Answer;
import com.demo.pojo.Question;
import com.demo.service.SearchService;
import com.demo.service.resultPojo.SearchServiceResultPojo;
import com.demo.util.PageUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    AnswerMapper answerMapper;
    @Autowired
    UserMapper userMapper;

    /*
    * 此处定死了，pageSize的值为18，其中question3个,answer15个
    * 在配合自定义的PageUtils获取offSet，上层调用的时候，只需要传递pageNum的值就可以了
    * */
    @Override
    public List<SearchServiceResultPojo> searchService(String keyWord, int pageNum) {
        int pageSize = 18;
        int offSet = PageUtils.pageUtils(pageNum, pageSize);
        List<Question> questions = questionMapper.SearchByKeyWord(keyWord, offSet, 3);
        List<Answer> answers = answerMapper.SearchByKeyWord(keyWord, offSet, 15);

        List<SearchServiceResultPojo> resultPojos = new ArrayList<>();
        for (Question question : questions) {
            SearchServiceResultPojo pojo = new SearchServiceResultPojo();
            pojo.setQuestionId(question.getQuestionId());
            pojo.setQuestion_title(question.getTitle());
            pojo.setQuestion_content(question.getContent());
            pojo.setQuestion_image(question.getQuestionImage());
            pojo.setQuestion_scanNum(question.getScanNum());
            resultPojos.add(pojo);
        }
        for (Answer answer : answers) {
            SearchServiceResultPojo pojo = new SearchServiceResultPojo();
            pojo.setAnswerId(answer.getAnswerId());
            pojo.setAnswer_questionId(answer.getQuestionId());
            pojo.setAnswer_questonTitle(questionMapper.selectQuestion(answer.getQuestionId()).getTitle());
            pojo.setAnswer_userName(userMapper.selectUserByUserId(answer.getUserId()).getUserName());
            pojo.setAnswer_content(answer.getContent());
            pojo.setAnswer_createTime(answer.getCreateTime());
            pojo.setAnswer_likeNum(answer.getLikeNum());
            pojo.setAnswer_unlikeNum(answer.getUnlikeNum());
            pojo.setAnswer_commentNum(answer.getCommentNum());
            resultPojos.add(pojo);
        }
        return resultPojos;
    }
}
