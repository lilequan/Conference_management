package org.example.conference_management.service.User_service.Impl;

import jakarta.annotation.Resource;
import org.example.conference_management.mapper.UserMapper;
import org.example.conference_management.service.User_service.UserService;
import org.example.conference_management.pojo.R;
import org.example.conference_management.pojo.user;
import org.example.conference_management.vo.userVo;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public R userRegister(userVo u) {
        userMapper.userRegister(u);
        return R.SUCCESS("注册成功");
    }

    @Override
    public R userLogin(userVo u) {

        user user = userMapper.userLogin(u);
        if (user != null) {
            if (user.getPassword().equals(u.getPassword())) {
                //userContextHolder.set(user);
                return R.SUCCESS("登入成功");
            } else {
                return R.ERROR("密码错误");
            }
        }
        return R.ERROR("test");
    }

    @Override
    public R selectById(String user_name) {
        int user_id = userMapper.selectById(user_name);
        if (user_id == 0) {
            return R.ERROR("不存在的用户");
        }
        return R.SUCCESS(user_id);
    }

}
