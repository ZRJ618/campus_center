package com.demo.mapper;

import com.demo.pojo.user.Student;
import com.demo.pojo.user.StudentModel;
import com.demo.pojo.introduce.ChargeMan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StudentMapper {

/*    StudentModel getStudentModelById(String studentId);
    Integer addStudentInfo(Student student);
    Integer updateStudentInfo(StudentModel studentModel, String modifyTime);
    Integer deletedStudentInfo(String studentId, String modifyTime);*/
}
