package com.demo.cache;

import com.demo.exception.ResultBody;
import com.demo.service.impl.SearchServiceImpl;
import com.demo.service.resultPojo.SearchServiceResultPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class SearchServiceCache {
    @Autowired
    SearchServiceImpl searchService;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public ResultBody searchService(String keyWord, int pageNum) throws NoSuchMethodException {
        //查询是否有key
        String key = this.getClass().getName()+"::"+this.getClass().getDeclaredMethod("searchService", String.class,int.class).getName()+"_"+keyWord.toString()+"_"+pageNum;
        ResultBody resultBody = (ResultBody) redisTemplate.opsForValue().get(key);
        if(resultBody != null){
            return resultBody;
        }
        //执行service层
        List<SearchServiceResultPojo> resultPojos = searchService.searchService(keyWord, pageNum);
        resultBody = ResultBody.success(resultPojos);
        //创建key
        redisTemplate.opsForValue().set(key,resultBody,60, TimeUnit.SECONDS);
        return resultBody;
    }

}
