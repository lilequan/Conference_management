package org.example.conference_management.service.User_service;

import org.example.conference_management.pojo.R;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.userVo;

public interface UserService {

    public R userLogin(userVo u);

    public R userRegister(userVo u);


}
