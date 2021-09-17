package com.demo.mapper;

import com.demo.pojo.AnswerLike;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AnswerLikeMapper {
    //添加一条记录
    boolean insertAnswerLike(@Param("userId") String userId, @Param("answerId") String answerId);

    //删除一条记录
    boolean deleteAnswerLike(@Param("userId") String userId, @Param("answerId") String answerId);

    //根据userId与answerId查找记录
    AnswerLike selectByUserIdAndAnswerId(@Param("userId") String userId, @Param("answerId") String answerId);
}
