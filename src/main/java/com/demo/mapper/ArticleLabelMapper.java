package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArticleLabelMapper {
    //查找某篇文章的所有标签
    List<Integer> selectLabelByArticle(@Param("articleId") String articleId);
}
