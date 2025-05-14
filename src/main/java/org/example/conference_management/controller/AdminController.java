package org.example.conference_management.controller;


import jakarta.annotation.Resource;
import jakarta.websocket.server.PathParam;
import org.example.conference_management.pojo.R;
import org.example.conference_management.service.Admin_service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    //TODO 会议审核

    @GetMapping("/selectUnReviewConferenceAll")
    public R selectUnReviewConferenceAll(){
        return adminService.SelectUnReviewConferenceAll();
    }

    @GetMapping("/conferenceReview")
    public R conferenceReview(@PathParam("conference_id") int conference_id){
        return adminService.ConferenceReview(conference_id);
    }

    //TODO 用户管理
    @GetMapping("selectUserAll")
    public R selectUserAll(){
        return adminService.selectUserAll();
    }

    //TODO 1.修改用户权限

    @GetMapping("/alterUserPower")
    public R alterUserPower(@PathParam("user_id")int user_id){
        return adminService.alterUserPower(user_id);
    }

    //TODO 2.删除用户

    //TODO 系统管理 (发布维护公告)
}
