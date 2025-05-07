package org.example.conference_management.controller;

import jakarta.annotation.Resource;
import org.example.conference_management.pojo.R;
import org.example.conference_management.service.Conference_service.ConferenceService;
import org.example.conference_management.vo.conferenceVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

    @Resource
    private ConferenceService conferenceService;

    //创建会议
    @PostMapping("/createConference")
    public R CreateConference(conferenceVo conferenceVo){
        return conferenceService.CreateConference(conferenceVo);
    }

    //TODO 选择加入会议

    //TODO 修改会议特邀码


    //TODO 会议管理
}
