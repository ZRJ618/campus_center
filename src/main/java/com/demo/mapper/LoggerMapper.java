package com.demo.mapper;

import com.demo.pojo.Logger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoggerMapper {
    boolean addLogger(@Param("logger") Logger logger);
}
