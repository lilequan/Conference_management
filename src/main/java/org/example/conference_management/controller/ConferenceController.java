package org.example.conference_management.controller;

import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.example.conference_management.pojo.R;
import org.example.conference_management.service.Conference_service.ConferenceService;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.userVo;
import org.example.conference_management.vo.user_conferenceVo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conference")
public class ConferenceController {

    @Resource
    private ConferenceService conferenceService;

    //创建会议
    @PostMapping("/createConference")
    public R CreateConference(@RequestBody conferenceVo conferenceVo){
        return conferenceService.CreateConference(conferenceVo);
    }

    //选择加入会议(以邀请码加入)
    @PostMapping("/joinConference")
    public R JoinConference(@RequestBody user_conferenceVo ucv){
        return conferenceService.JoinConference(ucv);
    }

    //修改会议特邀码
    @GetMapping("/alterInvcode")
    public R alterInv_code(@PathParam("conference_id") int conference_id, @PathParam("invitation_code") String invitation_code){
        return conferenceService.alterInv_code(conference_id,invitation_code);
    };

    //TODO 会议管理
    //1.查询会议
    @GetMapping("/selectConferenceAll")
    public R selectConferenceAll(@PathParam("convener_id") int convener_id){
        return conferenceService.selectConferenceAll(convener_id);
    }
    //2.修改会议内容
    @GetMapping("/alterConference")
    public R alterConference(@PathParam("conference_id")int conference_id,@PathParam("conference_name") String conference_name){
        return conferenceService.alterConference(conference_id,conference_name);
    };
    //3.删除会议
    @GetMapping("/deleteConference")
    public R deleteConference(@PathParam("conference_id")int conference_id){
        return conferenceService.deleteConference(conference_id);
    }

    //TODO 签到以及入住管理
    //1.会议签到
    @PostMapping("/signConference")
    public R signConference(@RequestBody userVo userVo){
        return conferenceService.signConference(userVo);
    }

    //2.入住管理
    @PostMapping("/checkManage")
    public R checkManage(@RequestBody user_conferenceVo user_conferenceVo){
        return conferenceService.checkManage(user_conferenceVo);
    }
}
