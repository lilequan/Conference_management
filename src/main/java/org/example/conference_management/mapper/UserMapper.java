package org.example.conference_management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.conference_management.pojo.User;
import org.example.conference_management.vo.userVo;

@Mapper
public interface UserMapper {


    @Insert("insert into user(password,user_name,isAdmin) values(#{password},#{user_name},#{isAdmin})")
    void userRegister(userVo u);

    @Select("select * from user where user_name=#{user_name}")
    User userLogin(userVo u);

    @Select("select user_id from user where user_name=#{user_name}")
    int selectById(String userName);
}
