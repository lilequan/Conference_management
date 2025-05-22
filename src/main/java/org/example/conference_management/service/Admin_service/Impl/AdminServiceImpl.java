package org.example.conference_management.service.Admin_service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.example.conference_management.dto.PageQueryDTO;
import org.example.conference_management.mapper.ConferenceMapper;
import org.example.conference_management.mapper.UserMapper;
import org.example.conference_management.pojo.PageR;
import org.example.conference_management.pojo.Conference;
import org.example.conference_management.service.Admin_service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private ConferenceMapper conferenceMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     * @param pageQueryDTO
     * @return
     */
    @Override
    public PageR pageQuery(PageQueryDTO pageQueryDTO) {
        PageHelper.startPage(pageQueryDTO.getPage(),pageQueryDTO.getPageSize());
        Page<Conference> page = conferenceMapper.pageQuery(pageQueryDTO);

        long total = page.getTotal();
        List<Conference> records =page.getResult();

        return new PageR(total,records);
    }

    @Override
    public void check(Integer status, int id) {
        conferenceMapper.updateStatus(status,id);
    }


}
