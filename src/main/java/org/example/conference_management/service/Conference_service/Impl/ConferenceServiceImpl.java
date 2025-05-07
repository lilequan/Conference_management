package org.example.conference_management.service.Conference_service.Impl;

import jakarta.annotation.Resource;
import org.example.conference_management.mapper.ConferenceMapper;
import org.example.conference_management.pojo.R;
import org.example.conference_management.service.Conference_service.ConferenceService;
import org.example.conference_management.vo.conferenceVo;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Resource
    private ConferenceMapper conferenceMapper;
    @Override
    public R CreateConference(conferenceVo conferenceVo) {
        conferenceMapper.CreateConference(conferenceVo);
        return R.SUCCESS("创建成功");
    }
}
