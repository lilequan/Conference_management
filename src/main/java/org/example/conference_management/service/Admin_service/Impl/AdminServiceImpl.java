package org.example.conference_management.service.Admin_service.Impl;

import jakarta.annotation.Resource;
import org.example.conference_management.mapper.AdminMapper;
import org.example.conference_management.pojo.R;
import org.example.conference_management.pojo.conference;
import org.example.conference_management.pojo.user;
import org.example.conference_management.service.Admin_service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public R SelectUnReviewConferenceAll() {
        List<conference> conferences = adminMapper.SelectUnReviewConferenceAll();
        return R.SUCCESS(conferences);
    }

    @Override
    public R ConferenceReview(int conference_id) {
        List<conference> conferences = adminMapper.SelectUnReviewConferenceAll();
        if (conferences == null) return R.ERROR("数据异常");

        for (conference c : conferences) {
            if (c.getConference_id() == conference_id) {
                adminMapper.ConferenceReview(conference_id);
                return R.SUCCESS("审核通过");
            }
        }
        return R.ERROR("不存在的会议");
    }
    @Override
    public R selectUserAll() {
        List<user> users = adminMapper.selectUserAll();
        return R.SUCCESS(users);
    }

    @Override
    public R alterUserPower(int user_id) {
        try {
            adminMapper.alterUserPower(user_id);
        } catch (Exception e) {
            return R.ERROR("操作异常");
        }
        return R.SUCCESS("修改成功");
    }

}
