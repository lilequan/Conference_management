package org.example.conference_management.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.conference_management.pojo.conference;
import org.example.conference_management.pojo.user;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from conference_management.conference where conference_state = 0")
    List<conference> SelectUnReviewConferenceAll();

    @Update("update conference_management.conference set conference_state=true where conference_id = #{conference_id}")
    void ConferenceReview(int conference_id);

    @Select("select user_id,user_name,email,isAdmin from conference_management.user")
    @Result(property = "adminFlag",column = "isAdmin")
    List<user> selectUserAll();

    @Update("update conference_management.user set isAdmin = true where user_id = #{user_id}")
    void alterUserPower(int user_id);
}
