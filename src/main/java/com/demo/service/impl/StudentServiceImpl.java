package com.demo.service.impl;

import com.demo.exception.GlobalException;
import com.demo.mapper.StudentMapper;
import com.demo.pojo.user.Student;
import com.demo.pojo.user.StudentModel;
import com.demo.service.StudentService;
import com.demo.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    /*@Resource
    StudentMapper studentMapper;

    @Override
    public StudentModel getPersonalStudent(String studentId) {
        StudentModel studentModel = studentMapper.getStudentModelById(studentId);
        if(studentModel == null){
            throw new GlobalException("500", "该用户未填写个人信息");
        }
        return studentModel;
    }

    @Override
    public boolean addStudentInfo(String studentId, String userName, String userRealName, String sex, String grade,
                             String major, String email, String headPortrait, String inchPhoto) {
        StudentModel studentModel = studentMapper.getStudentModelById(studentId);
        if(studentModel != null){
            throw new GlobalException("500", "该用户个人信息已存在,无法插入");
        }
        Student student = new Student();
        student.setUserId(UUID.randomUUID().toString());
        student.setStudentId(studentId);
        student.setUserName(userName);
        student.setUserRealName(userRealName);
        student.setSex(sex);
        student.setGrade(grade);
        student.setMajor(major);
        student.setEmail(email);
        student.setHeadPortrait(headPortrait);
        student.setInchPhoto(inchPhoto);
        student.setCreateTime(DateUtils.getDate());
        student.setModifyTime(DateUtils.getDate());
        student.setPowerId("0");
        Integer insert = studentMapper.addStudentInfo(student);
        if(insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudentInfo(String studentId, String userName, String userRealName,
                                  String sex, String grade, String major, String email,
                                  String headPortrait, String inchPhoto) {
        StudentModel studentModel = studentMapper.getStudentModelById(studentId);
        if(studentModel == null){
            throw new GlobalException("500", "该用户个人信息不存在，请先添加个人信息");
        }
        if(!studentModel.getUserName().equals(userName) && userName != null){
            studentModel.setUserName(userName);
        }
        if(!studentModel.getUserRealName().equals(userRealName) && userRealName != null){
            studentModel.setUserRealName(userRealName);
        }
        if(!studentModel.getSex().equals(sex) && sex != null){
            studentModel.setSex(sex);
        }
        if(!studentModel.getGrade().equals(grade) && grade != null){
            studentModel.setGrade(grade);
        }
        if(!studentModel.getMajor().equals(major) && major != null){
            studentModel.setMajor(major);
        }
        if(!studentModel.getEmail().equals(email) && email != null){
            studentModel.setEmail(email);
        }
        if(!studentModel.getHeadPortrait().equals(headPortrait) && headPortrait != null){
            studentModel.setHeadPortrait(headPortrait);
        }
        if(!studentModel.getInchPhoto().equals(inchPhoto) && inchPhoto != null){
            studentModel.setInchPhoto(inchPhoto);
        }
        Integer update = studentMapper.updateStudentInfo(studentModel, DateUtils.getDate());
        if(update == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deletedStudentInfo(String studentId) {
        StudentModel studentModel = studentMapper.getStudentModelById(studentId);
        if(studentModel == null){
            throw new GlobalException("500", "该用户信息不存在，无法删除");
        }
        Integer delete = studentMapper.deletedStudentInfo(studentId, DateUtils.getDate());
        if(delete == 1) {
            return true;
        }
        return false;
    }*/
}
