package org.example.conference_management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.example.conference_management.pojo.user;
import org.example.conference_management.vo.userVo;

@Mapper
public interface UserMapper {


    @Insert("insert into user(password,user_name,isAdmin) values(#{password},#{user_name},#{adminFlag})")
    void userRegister(userVo u);

    @Select("select * from user where user_name=#{user_name}")
    @Result(property ="adminFlag",column = "isAdmin")
    user userLogin(userVo u);

    @Select("select user_id from user where user_name=#{user_name}")
    int selectById(String userName);
}
