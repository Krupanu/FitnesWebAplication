package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    @Query("select a from Admin a where a.adminEmail = ?1 and a.adminPassword = ?2")
    Admin login(String adminEmail, String adminPassword);


}
