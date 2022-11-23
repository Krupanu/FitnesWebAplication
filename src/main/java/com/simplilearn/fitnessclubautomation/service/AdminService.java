package com.simplilearn.fitnessclubautomation.service;

import com.simplilearn.fitnessclubautomation.model.Admin;
import com.simplilearn.fitnessclubautomation.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin getAdmin(Long adminId) {
        return adminRepository.findById(adminId).get();
    }
}
