package com.demo.service.impl;

import com.demo.mapper.ArticleLabelMapper;
import com.demo.service.ArticleLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleLabelServiceImpl implements ArticleLabelService {
    @Autowired
    ArticleLabelMapper articleLabelMapper;

    @Override
    public List<Integer> selectLabelByArticle(String articleId) {
        return articleLabelMapper.selectLabelByArticle(articleId);
    }
}
