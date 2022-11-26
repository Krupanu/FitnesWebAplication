package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.model.SubscriptionPlan;
import com.simplilearn.fitnessclubautomation.model.Trainer;
import com.simplilearn.fitnessclubautomation.service.SubscriberService;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import com.simplilearn.fitnessclubautomation.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubscriberController {
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    private TrainerService trainerService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/subscriber/add", method = RequestMethod.POST)
    private Subscriber addSubscriber(
            @RequestParam(value = "subscriber_name", required = true) String subscriber_name,
            @RequestParam(value = "subscriber_age", required = true) int subscriber_age,
            @RequestParam(value = "subscriber_gender", required = true) String subscriber_gender,
            @RequestParam(value = "subscriber_address", required = true) String subscriber_address,
            @RequestParam(value = "subscriber_trainer_id", required = true) Long subscriber_trainer_id,
            @RequestParam(value = "subscription_plan_id", required = true) Long subscription_plan_id) {
        Trainer trainer = trainerService.getTrainer(subscriber_trainer_id);
        SubscriptionPlan subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(subscription_plan_id);
        Subscriber subscriber = new Subscriber(subscriber_name, subscriber_age, subscriber_gender, subscriber_address, true, trainer, subscriptionPlan);
        return subscriberService.addSubscriber(subscriber);
    }

    @RequestMapping(value = "/subscriber/edit", method = RequestMethod.POST)
    private Subscriber editSubscriber(@RequestParam(value = "subscriber_id", required = true) Long subscriber_id,
                                      @RequestParam(value = "subscriber_name", required = true) String subscriber_name,
                                      @RequestParam(value = "subscriber_age", required = true) int subscriber_age,
                                      @RequestParam(value = "subscriber_gender", required = true) String subscriber_gender,
                                      @RequestParam(value = "subscriber_status", required = true) boolean subscriber_status,
                                      @RequestParam(value = "subscriber_address", required = true) String subscriber_address,
                                      @RequestParam(value = "subscriber_trainer_id", required = true) Long subscriber_trainer_id,
                                      @RequestParam(value = "subscription_plan_id", required = true) Long subscription_plan_id) {
        Trainer trainer = trainerService.getTrainer(subscriber_trainer_id);
        SubscriptionPlan subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(subscription_plan_id);
        Subscriber subscriber = new Subscriber(subscriber_id, subscriber_name, subscriber_age, subscriber_gender, subscriber_address, subscriber_status, trainer, subscriptionPlan);
        return subscriberService.addSubscriber(subscriber);
    }

    @RequestMapping(value = "/subscriber/delete/{subscriber_id}")
    private Boolean deleteSubscriber(@PathVariable Long subscriber_id) {
        try {
            subscriberService.deleteSubscriber(subscriber_id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @RequestMapping(value = "/subscriber")
    private List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        try {
            subscribers = subscriberService.getAllSubscribers();
            return subscribers;
        } catch (Exception ex) {
            return subscribers;
        }
    }

    @RequestMapping(value = "/subscriber/{subscriber_id}")
    private Subscriber getSubscriber(@PathVariable Long subscriber_id) {
        Subscriber subscriber = new Subscriber();
        try {
            subscriber = subscriberService.getSubscriber(subscriber_id);
            return subscriber;
        } catch (Exception ex) {
            return subscriber;
        }
    }
}
