package com.demo.mapper;

import com.demo.pojo.introduce.ChargeMan;
import com.demo.pojo.user.User;
import com.demo.pojo.user.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;

@Mapper
@Repository
public interface UserMapper {
    /*学生登录*/
    UserModel login(String studentId, String password);
    UserModel getUserByIdAndPass(String userId, String password);
    UserModel getUserById(String userId);
    User getUserByStudentId(String studentId);
    Integer addUser(User user);
    Integer updatePassword(String userId, String password, String modifyTime);
    String getRealNameById(String userId);
    ChargeMan getChargeMan(String userId);


    //根据studentId查询user
    User selectUserById(@Param("studentId") String studentId);

    //注册
    boolean insertUser(@Param("userId") String userId, @Param("studentId") String studentId, @Param("password") String password, @Param("status") int status);

    //修改User信息
    boolean updateUser(@Param("userId") String userId, @Param("studentId") String studentId, @Param("password") String password, @Param("userName") String userName,
                       @Param("realName") String realName, @Param("sex") String sex, @Param("birthday") Date birthday, @Param("enterSchoolTime") Date enterSchoolTime,
                       @Param("major") String major, @Param("mobilePhone") String mobilePhone, @Param("email") String email,
                       @Param("selfImage") String selfImage, @Param("createTime") Timestamp createTime, @Param("status") int status,
                       @Param("idolSum") int idolSum, @Param("fansSum") int fansSum);

    //根据userId查询user
    User selectUserByUserId(@Param("userId") String userId);

    //根据userId展示个人页面
    //User selectSelf(@Param("userId") String userId);（已经废弃）

    //修改密码
    boolean updatePassword(@Param("password") String password, @Param("userId") String userId);

    //注销账户（修改status）
    boolean updataStatus(@Param("status") int status, @Param("userId") String userId);
}
