package org.example.conference_management.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.conference_management.pojo.R;
import org.example.conference_management.vo.conferenceVo;

@Mapper
public interface ConferenceMapper {

    @Insert("insert into conference(conference_name,convener_id,invitation_code)" +
            "values (#{conference_name},#{convener_id},#{invitation_code})")
    void CreateConference(conferenceVo conferenceVo);
}
