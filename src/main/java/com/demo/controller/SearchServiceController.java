package com.demo.controller;

import com.demo.cache.SearchServiceCache;
import com.demo.exception.ResultBody;
import com.demo.service.impl.SearchServiceImpl;
import com.demo.service.resultPojo.SearchServiceResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class SearchServiceController {
    @Autowired
    SearchServiceCache searchServiceCache;

    @PostMapping("/searchService")
    public ResultBody searchService(String keyWord, int pageNum) throws NoSuchMethodException {
        ResultBody resultBody = searchServiceCache.searchService(keyWord, pageNum);
        return resultBody;
    }
}
