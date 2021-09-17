package com.demo.mapper;

import com.demo.pojo.Label;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LabelMapper {
    //根据label查询自增Id
    Integer selectSelfAdd(@Param("label") String label);

    //根据自增Id查询label
    String selectLabel(@Param("selfAdd") int selfAdd);

    //插入一条记录
    boolean insert(@Param("label") String labe);

    //修改label
    boolean update(@Param("newLabel") String newLabel, @Param("oldLabel") String oldLabel);

    //查询所有label
    List<Label> selectAll();

}
