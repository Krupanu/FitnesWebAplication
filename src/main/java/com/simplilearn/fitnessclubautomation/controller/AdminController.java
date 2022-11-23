package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Admin;
import com.simplilearn.fitnessclubautomation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("/")
    private Admin getAdmin() {
        return adminService.getAdmin(1L);
    }
}
