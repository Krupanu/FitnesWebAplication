package com.simplilearn.fitnessclubautomation.service;

import com.simplilearn.fitnessclubautomation.model.Trainer;
import com.simplilearn.fitnessclubautomation.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    @Autowired
    TrainerRepository trainerRepository;

    public Trainer addTrainer(Trainer tr) {
        return trainerRepository.save(tr);
    }

    public void deleteTrainer(Long trainer_id) {
        trainerRepository.deleteById(trainer_id);
    }

    public List<Trainer> getAllTrainers() {
        List<Trainer> trainers = new ArrayList<>();
        trainerRepository.findAll().forEach(trainers::add);
        return trainers;
    }

    public Trainer getTrainer(Long trainer_id) {
        return trainerRepository.findById(trainer_id).get();
    }
}
