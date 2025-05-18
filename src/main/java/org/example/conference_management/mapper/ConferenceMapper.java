package org.example.conference_management.mapper;


import org.apache.ibatis.annotations.*;
import org.example.conference_management.pojo.conference;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.user_conferenceVo;

import java.util.List;

@Mapper
public interface ConferenceMapper {

    //创建会议
    @Insert("insert into conference(conference_name,convener_id,invitation_code)" +
            "values (#{conference_name},#{convener_id},#{invitation_code})")
    void CreateConference(conferenceVo conferenceVo);

    //加入会议
    @Insert("insert into user_conference(user_id, conference_id, round_trip_time,accommodation_requirements,remarks) " +
            "values (#{user_id},#{conference_id},#{round_trip_time},#{accommodation_requirements},#{remarks})")
    void JoinConference(user_conferenceVo ucv);

    //查找指定会议
    @Select("select * from conference where conference_id = #{conference_id}")
    conference SelectById(int conference_id);

    //批量查询会议
    //@Select("select * from conference where conference_id in #{conferenceIds}")
    List<conference> SelectByIds(@Param("conferenceIds")List<Integer> conferenceIds);

    //查找我创建的会议
    @Select("select * from conference where convener_id = #{convener_id}")
    List<conference> selectConferenceAll(int convener_id);
    //查找已审核的会议
    @Select("select * from conference where conference_state = 1")
    List<conference> selectReviewedConference();
    //查找我加入的会议
    @Select("select conference_id from user_conference where user_id = #{user_id}")
    List<Integer> selectJoinedConference(int user_id);
    @Update("update conference_management.conference set invitation_code = #{invitation_code} " +
            "where conference_id =#{conference_id}")
    void alterInv_code(int conference_id, String invitation_code);

    @Update("update conference_management.conference set conference_name = #{conference_name}" +
            " where conference_id = #{conference_id}")
    void alterConference(int conference_id, String conference_name);

    @Delete("delete from conference where conference_id = #{conference_id}")
    boolean deleteConference(int conference_id);


}
