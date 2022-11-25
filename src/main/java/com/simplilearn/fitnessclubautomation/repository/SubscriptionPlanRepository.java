package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.SubscriptionPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionPlanRepository extends CrudRepository<SubscriptionPlan, Long> {
}
