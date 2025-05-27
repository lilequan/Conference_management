package org.example.conference_management.mapper;


import org.apache.ibatis.annotations.*;
import org.example.conference_management.pojo.conference;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.user_conferenceVo;

import java.util.List;

@Mapper
public interface ConferenceMapper {

    @Insert("insert into conference(conference_name,convener_id,invitation_code)" +
            "values (#{conference_name},#{convener_id},#{invitation_code})")
    void CreateConference(conferenceVo conferenceVo);

    @Insert("insert into user_conference(user_id, conference_id, round_trip_time,accommodation_requirements,remarks) " +
            "values (#{user_id},#{conference_id},#{round_trip_time},#{accommodation_requirements},#{remarks})")
    void JoinConference(user_conferenceVo ucv);

    @Select("select * from conference where conference_id = #{conference_id}")
    conference SelectById(int conference_id);

    @Update("update conference_management.conference set invitation_code = #{invitation_code} " +
            "where conference_id =#{conference_id}")
    void alterInv_code(int conference_id, String invitation_code);

    @Select("select * from conference where convener_id = #{convener_id}")
    List<conference> selectConferenceAll(int convener_id);

    @Update("update conference_management.conference set conference_name = #{conference_name}" +
            " where conference_id = #{conference_id}")
    void alterConference(int conference_id, String conference_name);

    @Delete("delete from conference where conference_id = #{conference_id}")
    boolean deleteConference(int conference_id);

    @Update("update user_conference set roundTripTime = #{ucv.round_trip_time}, " +
            "accommodationRequirements = #{ucv.accommodation_requirements}, " +
            "remarks = #{ucv.remarks}")
    void checkConference(user_conferenceVo ucv);
}
