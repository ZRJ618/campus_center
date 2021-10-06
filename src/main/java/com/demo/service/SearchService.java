package com.demo.service;

import com.demo.service.resultPojo.SearchServiceResultPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {
    List<SearchServiceResultPojo> searchService(String keyWord, int pageNum);
}
