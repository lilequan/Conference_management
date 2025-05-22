package org.example.conference_management.service.Admin_service;

import org.example.conference_management.dto.PageQueryDTO;
import org.example.conference_management.pojo.PageR;

public interface AdminService {

    PageR pageQuery(PageQueryDTO pageQueryDTO);

    void check(Integer status, int id);
}
