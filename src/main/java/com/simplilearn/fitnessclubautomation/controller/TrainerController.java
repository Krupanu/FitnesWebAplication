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

    @RequestMapping(value = "/trainer/edit-trainer/{trainer_id}")
    private String editTrainer(ModelMap modelMap, @PathVariable Long trainer_id) {
        int[] experience = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        modelMap.addAttribute("experience", experience);
        Trainer trainer = trainerService.getTrainer(trainer_id);
        modelMap.addAttribute("trainer", trainer);
        return "edit-trainer";
    }

    @RequestMapping(value = "/trainer/edit", method = RequestMethod.POST)
    private String editTrainer(@RequestParam(value = "trainer_id", required = true) Long trainer_id,
                               @RequestParam(value = "trainer_name", required = true) String trainer_name,
                               @RequestParam(value = "trainer_age", required = true) int trainer_age,
                               @RequestParam(value = "trainer_gender", required = true) String trainer_gender,
                               @RequestParam(value = "trainer_experience", required = true) int trainer_experience,
                               @RequestParam(value = "trainer_address", required = true) String trainer_address) {
        Trainer tr = new Trainer(trainer_id, trainer_name, trainer_age, trainer_gender, trainer_experience, trainer_address);
        trainerService.addTrainer(tr);
        return "redirect:/trainer";
    }

    @RequestMapping(value = "/trainer/delete/{trainer_id}", method = RequestMethod.GET)
    private String deleteTrainer(ModelMap modelMap, @PathVariable Long trainer_id) {
        try {
            trainerService.deleteTrainer(trainer_id);
            modelMap.addAttribute("success", true);
            modelMap.addAttribute("message", "Data deleted successfully.");
            return "redirect:/trainer";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/trainer";
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
    private String getTrainer(ModelMap modelMap, @PathVariable Long trainer_id) {
        Trainer trainer = new Trainer();
        try {
            trainer = trainerService.getTrainer(trainer_id);
            modelMap.addAttribute("trainer", trainer);
            return "trainer-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/trainer";
        }
    }
}
