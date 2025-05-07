package org.example.conference_management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.conference_management.pojo.user;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.userVo;

@Mapper
public interface UserMapper {


    @Insert("insert into user(password,email,user_name) values(#{password},#{email},#{user_name})")
    void userRegister(userVo u);

    @Select("select * from user where user_name=#{user_name}")
    user userLogin(userVo u);


}
