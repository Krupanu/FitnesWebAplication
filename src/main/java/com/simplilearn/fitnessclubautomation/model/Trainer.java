package com.simplilearn.fitnessclubautomation.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id", nullable = false)
    private Long trainerId;
    @Column(name = "trainer_name", nullable = false)
    private String trainerName;
    @Column(name = "trainer_age", nullable = false)
    private int trainerAge;
    @Column(name = "trainer_gender", nullable = false)
    private String trainerGender;
    @Column(name = "trainer_experience", nullable = false)
    private int trainerExperience;
    @Column(name = "trainer_address", nullable = false)
    private String trainerAddress;

    public Trainer() {
    }

    public Trainer(Long trainerId, String trainerName, int trainerAge, String trainerGender, int trainerExperience, String trainerAddress) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.trainerAge = trainerAge;
        this.trainerGender = trainerGender;
        this.trainerExperience = trainerExperience;
        this.trainerAddress = trainerAddress;
    }

    public Trainer(String trainerName, int trainerAge, String trainerGender, int trainerExperience, String trainerAddress) {
        this.trainerName = trainerName;
        this.trainerAge = trainerAge;
        this.trainerGender = trainerGender;
        this.trainerExperience = trainerExperience;
        this.trainerAddress = trainerAddress;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getTrainerAge() {
        return trainerAge;
    }

    public void setTrainerAge(int trainerAge) {
        this.trainerAge = trainerAge;
    }

    public String getTrainerGender() {
        return trainerGender;
    }

    public void setTrainerGender(String trainerGender) {
        this.trainerGender = trainerGender;
    }

    public int getTrainerExperience() {
        return trainerExperience;
    }

    public void setTrainerExperience(int trainerExperience) {
        this.trainerExperience = trainerExperience;
    }

    public String getTrainerAddress() {
        return trainerAddress;
    }

    public void setTrainerAddress(String trainerAddress) {
        this.trainerAddress = trainerAddress;
    }
}
