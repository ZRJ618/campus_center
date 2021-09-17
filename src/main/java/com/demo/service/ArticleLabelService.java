package com.demo.service;

import java.util.List;

public interface ArticleLabelService {
    //查找某篇文章的所有标签
    List<Integer> selectLabelByArticle(String articleId);

}
