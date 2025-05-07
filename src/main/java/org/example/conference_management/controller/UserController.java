package org.example.conference_management.controller;

import jakarta.annotation.Resource;
import org.example.conference_management.service.User_service.UserService;
import org.example.conference_management.pojo.R;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.userVo;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //用户注册
    @PostMapping("/register")
    public R userRegister(@RequestBody userVo u) {
        return userService.userRegister(u);
    }
    //用户登入
    @PostMapping("/login")
    public R userLogin(@RequestBody userVo u) {

        return userService.userLogin(u);
    }




}
