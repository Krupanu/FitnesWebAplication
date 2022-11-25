package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
