package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Query("SELECT admin FROM Admin admin WHERE admin.adminEmail=:adminEmail AND admin.adminPassword=:adminPassword")
    Admin findByAdminEmailAndAdminPassword(@Param("adminEmail") String adminEmail, @Param("adminPassword") String adminPassword);


}
