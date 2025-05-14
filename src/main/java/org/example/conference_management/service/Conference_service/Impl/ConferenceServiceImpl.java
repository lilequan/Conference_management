package org.example.conference_management.service.Conference_service.Impl;

import jakarta.annotation.Resource;
import org.example.conference_management.mapper.ConferenceMapper;
import org.example.conference_management.mapper.UserMapper;
import org.example.conference_management.pojo.R;
import org.example.conference_management.pojo.conference;
import org.example.conference_management.service.Conference_service.ConferenceService;
import org.example.conference_management.vo.conferenceVo;
import org.example.conference_management.vo.user_conferenceVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Resource
    private ConferenceMapper conferenceMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public R CreateConference(conferenceVo conferenceVo) {
        conferenceMapper.CreateConference(conferenceVo);
        return R.SUCCESS("创建成功");
    }

    @Override
    public R JoinConference(user_conferenceVo ucv) {
        conference conference = conferenceMapper.SelectById(ucv.getConference_id());
        if (conference != null) {
            if (conference.getInvitation_code().equals(ucv.getInvitation_code())) {
                conferenceMapper.JoinConference(ucv);
                return R.SUCCESS("加入成功");
            }
            return R.ERROR("错误的邀请码");
        }
        return R.ERROR("无效的会议");
    }

    @Override
    public R alterInv_code(int conference_id, String invitation_code) {
        conference conference = conferenceMapper.SelectById(conference_id);
        if (conference!=null){
            try {
                conferenceMapper.alterInv_code(conference_id,invitation_code);
                return R.SUCCESS("修改成功");
            } catch (Exception e) {
                return R.ERROR("网络繁忙");
            }
        }
        return R.ERROR("无效的会议");
    }

    @Override
    public R selectConferenceAll(int convener_id) {
        List<conference> conferences = conferenceMapper.selectConferenceAll(convener_id);
        if (conferences==null)return R.ERROR(null);
        return R.SUCCESS(conferences);
    }

    @Override
    public R alterConference(int conference_id, String conference_name) {
        conference conference = conferenceMapper.SelectById(conference_id);
        if (conference!=null){
            try {
                conferenceMapper.alterConference(conference_id,conference_name);
                return R.SUCCESS("修改成功");
            } catch (Exception e) {
                return R.ERROR("网络繁忙");
            }
        }

        return R.ERROR("无效的会议");
    }

    @Override
    public R deleteConference(int conference_id) {
        boolean flag =  conferenceMapper.deleteConference(conference_id);
        return flag?R.SUCCESS("删除成功"):R.ERROR("无效的会议");
    }

    @Override
    public R signConference(int user_id, int conference_id) {
        conferenceMapper.signConference(user_id,conference_id);
        return R.SUCCESS("签到成功");
    }

    @Override
    public R checkManage(user_conferenceVo ucv) {
        conferenceMapper.checkConference(ucv);
        return R.SUCCESS("入住信息修改成功");
    }
}
