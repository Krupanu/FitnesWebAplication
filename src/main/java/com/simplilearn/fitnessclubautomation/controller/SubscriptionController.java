package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.SubscriptionPlan;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubscriptionController {
    @Autowired
    SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/subscriptionplan/add", method = RequestMethod.POST)
    private SubscriptionPlan addSubscriptionPlan(@RequestParam(value = "plan_title", required = true) String plan_title,
                                                 @RequestParam(value = "plan_duration", required = true) int plan_duration,
                                                 @RequestParam(value = "plan_fees", required = true) int plan_fees) {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(plan_title, plan_duration, plan_fees);
        return subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
    }

    @RequestMapping(value = "/subscriptionplan/edit", method = RequestMethod.POST)
    private SubscriptionPlan editSubscriptionPlan(@RequestParam(value = "plan_id", required = true) Long plan_id,
                                                  @RequestParam(value = "plan_title", required = true) String plan_title,
                                                  @RequestParam(value = "plan_duration", required = true) int plan_duration,
                                                  @RequestParam(value = "plan_fees", required = true) int plan_fees) {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(plan_id, plan_title, plan_duration, plan_fees);
        return subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
    }

    @RequestMapping(value = "/subscriptionplan/delete/{plan_id}")
    private Boolean deleteSubscriptionPlan(@PathVariable Long plan_id) {
        try {
            subscriptionPlanService.deleteSubscriptionPlan(plan_id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @RequestMapping(value = "/subscriptionplan")
    private List<SubscriptionPlan> getAllSubscriptionPlans() {
        List<SubscriptionPlan> subscriptionPlans = new ArrayList<>();
        try {
            subscriptionPlans = subscriptionPlanService.getAllSubscriptionPlans();
            return subscriptionPlans;
        } catch (Exception ex) {
            return subscriptionPlans;
        }
    }

    @RequestMapping(value = "/subscriptionplan/{plan_id}")
    private SubscriptionPlan getSubscriptionPlan(@PathVariable Long plan_id) {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        try {
            subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(plan_id);
            return subscriptionPlan;
        } catch (Exception ex) {
            return subscriptionPlan;
        }
    }
}