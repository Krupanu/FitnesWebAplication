package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Trainer;
import com.simplilearn.fitnessclubautomation.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @RequestMapping(value = "/trainer/add-new")
    private String addTrainer() {
        return "add-trainer";
    }

    @RequestMapping(value = "/trainer/add", method = RequestMethod.POST)
    private String addTrainer(@RequestParam(value = "trainer_name", required = true) String trainer_name,
                               @RequestParam(value = "trainer_age", required = true) int trainer_age,
                               @RequestParam(value = "trainer_gender", required = true) String trainer_gender,
                               @RequestParam(value = "trainer_experience", required = true) int trainer_experience,
                               @RequestParam(value = "trainer_address", required = true) String trainer_address) {
        Trainer tr = new Trainer(trainer_name, trainer_age, trainer_gender, trainer_experience, trainer_address);
        tr = trainerService.addTrainer(tr);
        return "redirect:/trainer";
    }

    @RequestMapping(value = "/trainer/edit", method = RequestMethod.POST)
    private Trainer editTrainer(@RequestParam(value = "trainer_id", required = true) Long trainer_id, @RequestParam(value = "trainer_name", required = true) String trainer_name, @RequestParam(value = "trainer_age", required = true) int trainer_age, @RequestParam(value = "trainer_gender", required = true) String trainer_gender, @RequestParam(value = "trainer_experience", required = true) int trainer_experience, @RequestParam(value = "trainer_address", required = true) String trainer_address) {
        Trainer tr = new Trainer(trainer_id, trainer_name, trainer_age, trainer_gender, trainer_experience, trainer_address);
        return trainerService.addTrainer(tr);
    }

    @RequestMapping(value = "/trainer/delete/{trainer_id}", method = RequestMethod.GET)
    private Boolean deleteTrainer(@PathVariable Long trainer_id) {
        try {
            trainerService.deleteTrainer(trainer_id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @RequestMapping(value = "/trainer")
    private String getAllTrainers(ModelMap modelMap) {
        List<Trainer> trainers = new ArrayList<>();
        try {
            trainers = trainerService.getAllTrainers();
            if (trainers.size() > 0) {
                modelMap.addAttribute("trainers", trainers);
                modelMap.addAttribute("message", "Total <b>" + trainers.size() + "</b> trainers found.");
            } else {
                modelMap.addAttribute("message", "Total <b>" + trainers.size() + "</b> trainers found.");
            }
            return "trainer-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "trainer-list";
        }
    }

    @RequestMapping(value = "/trainer/{trainer_id}")
    private Trainer getTrainer(@PathVariable Long trainer_id) {
        Trainer trainer = new Trainer();
        try {
            trainer = trainerService.getTrainer(trainer_id);
            return trainer;
        } catch (Exception ex) {
            return trainer;
        }
    }
}
