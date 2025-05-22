package org.example.conference_management.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.conference_management.dto.PageQueryDTO;
import org.example.conference_management.pojo.PageR;
import org.example.conference_management.service.Admin_service.AdminService;
import org.springframework.web.bind.annotation.*;
import org.example.conference_management.pojo.R;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;


    /**
     * 分页查询会议
     * @param pageQueryDTO
     * @return
     */
    @GetMapping("/converence/page")
    public R page(PageQueryDTO pageQueryDTO){
        log.info("会议分页查询，参数：{}",pageQueryDTO);
        PageR pageR =adminService.pageQuery(pageQueryDTO);
        return R.SUCCESS(pageR);
    }

    /**
     * 审批会议
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/conference/status/{status}")
    public R check(@PathVariable Integer status,int id){
        log.info("审批会议：{}，{}",status,id);
        adminService.check(status,id);
        return R.SUCCESS();
    }


}
