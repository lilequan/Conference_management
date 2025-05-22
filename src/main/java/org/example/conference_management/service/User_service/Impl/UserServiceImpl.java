package org.example.conference_management.service.User_service.Impl;

import jakarta.annotation.Resource;
import org.example.conference_management.mapper.UserMapper;
import org.example.conference_management.service.User_service.UserService;
import org.example.conference_management.pojo.R;
import org.example.conference_management.pojo.User;
import org.example.conference_management.vo.userVo;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public R userRegister(userVo u) {
        String password = DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
        u.setPassword(password);
        userMapper.userRegister(u);

        return R.SUCCESS("注册成功");
    }

    @Override
    public R userLogin(userVo u) {

        User user = userMapper.userLogin(u);
        String password=DigestUtils.md5DigestAsHex(u.getPassword().getBytes());
        if (user != null) {
            if (user.getPassword().equals(password)) {
                //userContextHolder.set(user);
                return R.SUCCESS(user);
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
