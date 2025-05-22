package org.example.conference_management.mapper;


import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.example.conference_management.dto.PageQueryDTO;
import org.example.conference_management.pojo.Conference;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.user_conferenceVo;

import java.util.List;

@Mapper
public interface ConferenceMapper {

    Page<Conference> pageQuery(PageQueryDTO pageQueryDTO);


    @Insert("insert into conference(conference_name,convener_id,invitation_code)" +
            "values (#{conference_name},#{convener_id},#{invitation_code})")
    void CreateConference(conferenceVo conferenceVo);

    @Insert("insert into user_conference(user_id, conference_id, round_trip_time,accommodation_requirements,remarks) " +
            "values (#{user_id},#{conference_id},#{round_trip_time},#{accommodation_requirements},#{remarks})")
    void JoinConference(user_conferenceVo ucv);

    @Select("select * from conference where conference_id = #{conference_id}")
    Conference SelectById(int conference_id);

    @Update("update conference_management.conference set invitation_code = #{invitation_code} " +
            "where conference_id =#{conference_id}")
    void alterInv_code(int conference_id, String invitation_code);

    @Select("select * from conference where convener_id = #{convener_id}")
    List<Conference> selectConferenceAll(int convener_id);

    @Update("update conference_management.conference set conference_name = #{conference_name}" +
            " where conference_id = #{conference_id}")
    void alterConference(int conference_id, String conference_name);

    @Delete("delete from conference where conference_id = #{conference_id}")
    boolean deleteConference(int conference_id);

    @Update("update user_conference set roundTripTime = #{ucv.round_trip_time}, " +
            "accommodationRequirements = #{ucv.accommodation_requirements}, " +
            "remarks = #{ucv.remarks}")
    void checkConference(user_conferenceVo ucv);

    //修改状态
    @Update("update conference set conference_status = #{status} where conference_id = #{id}")
    void updateStatus(Integer status, int id);
}
