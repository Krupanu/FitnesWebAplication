package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.model.SubscriptionPlan;
import com.simplilearn.fitnessclubautomation.model.Trainer;
import com.simplilearn.fitnessclubautomation.service.SubscriberService;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import com.simplilearn.fitnessclubautomation.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SubscriberController {
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/subscriber/add-new")
    private String addSubscriber(ModelMap modelMap) {
        List<Trainer> trainers = trainerService.getAllTrainers();
        modelMap.addAttribute("trainers", trainers);

        List<SubscriptionPlan> subscriptionPlans = subscriptionPlanService.getAllSubscriptionPlans();
        modelMap.addAttribute("subscriptionPlans", subscriptionPlans);
        return "add-subscriber";
    }

    @RequestMapping(value = "/subscriber/add", method = RequestMethod.POST)
    private String addSubscriber(
            @RequestParam(value = "subscriber_name", required = true) String subscriber_name,
            @RequestParam(value = "subscriber_age", required = true) int subscriber_age,
            @RequestParam(value = "subscriber_gender", required = true) String subscriber_gender,
            @RequestParam(value = "subscriber_address", required = true) String subscriber_address,
            @RequestParam(value = "subscriber_trainer_id", required = true) Long subscriber_trainer_id,
            @RequestParam(value = "subscription_plan_id", required = true) Long subscription_plan_id) {
        Trainer trainer = trainerService.getTrainer(subscriber_trainer_id);
        SubscriptionPlan subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(subscription_plan_id);
        Subscriber subscriber = new Subscriber(subscriber_name, subscriber_age, subscriber_gender, subscriber_address, true, 0, trainer, subscriptionPlan);
        if (subscriberService.addSubscriber(subscriber) != null) {
            return "redirect:/subscriber";
        } else {
            return "redirect:/subscriber";
        }
    }

    @RequestMapping(value = "/subscriber/edit-subscriber/{subscriber_id}")
    private String editSubscriber(ModelMap modelMap, @PathVariable Long subscriber_id) {
        Subscriber subscriber = subscriberService.getSubscriber(subscriber_id);
        modelMap.addAttribute("subscriber", subscriber);

        List<Trainer> trainers = trainerService.getAllTrainers();
        modelMap.addAttribute("trainers", trainers);

        List<SubscriptionPlan> subscriptionPlans = subscriptionPlanService.getAllSubscriptionPlans();
        modelMap.addAttribute("subscriptionPlans", subscriptionPlans);
        return "edit-subscriber";
    }

    @RequestMapping(value = "/subscriber/edit", method = RequestMethod.POST)
    private String editSubscriber(ModelMap modelMap, HttpServletRequest request, @RequestParam(value = "subscriber_id", required = true) Long subscriber_id,
                                  @RequestParam(value = "subscriber_name", required = true) String subscriber_name,
                                  @RequestParam(value = "subscriber_age", required = true) int subscriber_age,
                                  @RequestParam(value = "subscriber_gender", required = true) String subscriber_gender,
                                  @RequestParam(value = "subscriber_status", required = true) boolean subscriber_status,
                                  @RequestParam(value = "subscriber_address", required = true) String subscriber_address,
                                  @RequestParam(value = "subscriber_trainer_id", required = true) Long subscriber_trainer_id,
                                  @RequestParam(value = "subscription_plan_id", required = true) Long subscription_plan_id) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) {
            return "redirect:/";
        }
        if (subscriber_trainer_id == 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Please select a valid trainer");
            return "edit-subscriber";
        }
        if (subscription_plan_id == 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Please select a valid subscription plan");
            return "edit-subscriber";
        }
        Trainer trainer = trainerService.getTrainer(subscriber_trainer_id);
        SubscriptionPlan subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(subscription_plan_id);
        int paid_fees = subscriberService.getSubscriber(subscriber_id).getSubscriberFeesPaid();
        Subscriber subscriber = new Subscriber(subscriber_id, subscriber_name, subscriber_age, subscriber_gender, subscriber_address, subscriber_status, paid_fees, trainer, subscriptionPlan);
        subscriber = subscriberService.addSubscriber(subscriber);
        return "redirect:/subscriber";
    }

    @RequestMapping(value = "/subscriber/delete/{subscriber_id}")
    private String deleteSubscriber(@PathVariable Long subscriber_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) {
            return "redirect:/";
        }
        try {
            subscriberService.deleteSubscriber(subscriber_id);
            return "redirect:/subscriber";
        } catch (Exception ex) {
            return "redirect:/subscriber";
        }
    }

    @RequestMapping(value = "/subscriber")
    private String getAllSubscribers(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) {
            return "redirect:/";
        }
        List<Subscriber> subscribers = new ArrayList<>();
        try {
            subscribers = subscriberService.getAllSubscribers();
            modelMap.addAttribute("subscriber_list", subscribers);
            modelMap.addAttribute("message", "Total <b>" + subscribers.size() + "</b> subscribers found.");
            return "subscriber-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage() + "");
            return "subscriber-list";
        }
    }

    @RequestMapping(value = "/subscriber/{subscriber_id}")
    private String getSubscriber(ModelMap modelMap, HttpServletRequest request, @PathVariable Long subscriber_id) {
        Subscriber subscriber = new Subscriber();
        HttpSession session = request.getSession();
        if (session.getAttribute("adminId") == null) {
            return "redirect:/";
        }
        try {
            subscriber = subscriberService.getSubscriber(subscriber_id);
            modelMap.addAttribute("subscriber", subscriber);
            return "subscriber-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/subscriber/{subscriber_id}";
        }
    }
}
