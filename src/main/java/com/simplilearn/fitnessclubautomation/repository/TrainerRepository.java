package com.simplilearn.fitnessclubautomation.repository;

import com.simplilearn.fitnessclubautomation.model.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
}
