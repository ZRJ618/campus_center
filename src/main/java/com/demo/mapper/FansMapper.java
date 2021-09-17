package com.demo.mapper;

import com.demo.pojo.Fans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FansMapper {

    //插入一条数据
    boolean insertUser(@Param("userId") String userId, @Param("fansId") String fansId);

    //删除一条数据
    boolean deleteUser(@Param("userId") String userId, @Param("fansId") String fansId);

    //根据userId与fansId查询数据
    Fans selectByUserIdAndFansId(@Param("userId") String userId, @Param("fansId") String fansId);

    //根据userId查询其关注者总数
    Integer selectFocusNum(@Param("userId") String userId);

    //根据userId查询其粉丝总数
    Integer selectFansNum(@Param("userId") String userId);

    //根据userId查询其所有关注者
    List<Fans> selectFocus(@Param("userId") String userId);

    //分页查询:根据userId查询其所有关注者
    List<Fans> selectFocusByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);

    //根据userId查询其所有粉丝
    List<Fans> selectFans(@Param("userId") String userId);

    //分页查询:根据userId查询其所有粉丝
    List<Fans> selectFansByPage(@Param("userId") String userId, @Param("offSet") int offSet, @Param("pageSize") int pageSize);
}
