package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByAdminEmailAndAdminPassword(@NonNull String adminEmail, @NonNull String adminPassword);

}
