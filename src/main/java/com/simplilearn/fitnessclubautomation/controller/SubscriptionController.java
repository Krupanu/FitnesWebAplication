package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.SubscriptionPlan;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SubscriptionController {
    @Autowired
    SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/subscriptionplan/add-new")
    private String addSubscriptionPlan() {
        return "add-plan";
    }

    @RequestMapping(value = "/subscriptionplan/add", method = RequestMethod.POST)
    private String addSubscriptionPlan(ModelMap modelMap,
                                       @RequestParam(value = "plan_title", required = true) String plan_title,
                                       @RequestParam(value = "plan_duration", required = true) int plan_duration,
                                       @RequestParam(value = "plan_fees", required = true) int plan_fees) {
        if (plan_duration <= 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid duration");
            return "add-plan";
        }
        if (plan_fees <= 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid fees");
            return "add-plan";
        }
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(plan_title, plan_duration, plan_fees);
        subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
        modelMap.addAttribute("success", true);
        modelMap.addAttribute("message", "Plan added successfully.");
        return "redirect:/subscriptionplan";
    }

    @RequestMapping(value = "/subscriptionplan/edit-plan/{plan_id}")
    private String editSubscriptionPlan(ModelMap modelMap, @PathVariable Long plan_id) {
        SubscriptionPlan plan = null;
        try {
            plan = subscriptionPlanService.getSubscriptionPlan(plan_id);
            if (plan != null) {
                modelMap.addAttribute("plan", plan);
                return "edit-plan";
            } else {
                return "redirect:/subscriptionplan";
            }
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/subscriptionplan";
        }
    }

    @RequestMapping(value = "/subscriptionplan/edit", method = RequestMethod.POST)
    private String editSubscriptionPlan(ModelMap modelMap,
                                        @RequestParam(value = "plan_id", required = true) Long plan_id,
                                        @RequestParam(value = "plan_title", required = true) String plan_title,
                                        @RequestParam(value = "plan_duration", required = true) int plan_duration,
                                        @RequestParam(value = "plan_fees", required = true) int plan_fees) {
        if (plan_duration <= 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid duration");
            return "redirect:/subscriptionplan/edit-plan/" + plan_id;
        }
        if (plan_fees <= 0) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid fees");
            return "redirect:/subscriptionplan/edit-plan/" + plan_id;
        }
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan(plan_id, plan_title, plan_duration, plan_fees);
        subscriptionPlanService.addSubscriptionPlan(subscriptionPlan);
        modelMap.addAttribute("success", true);
        modelMap.addAttribute("message", "Plan data saved successfully.");
        return "redirect:/subscriptionplan";
    }

    @RequestMapping(value = "/subscriptionplan/delete/{plan_id}")
    private String deleteSubscriptionPlan(ModelMap modelMap, @PathVariable Long plan_id) {
        try {
            subscriptionPlanService.deleteSubscriptionPlan(plan_id);
            return "redirect:/subscriptionplan";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/subscriptionplan";
        }
    }

    @RequestMapping(value = "/subscriptionplan")
    private String getAllSubscriptionPlans(ModelMap modelMap) {
        List<SubscriptionPlan> subscriptionPlans = new ArrayList<>();
        try {
            subscriptionPlans = subscriptionPlanService.getAllSubscriptionPlans();
            modelMap.addAttribute("subscriptionPlans", subscriptionPlans);
//            modelMap.addAttribute("success", true);
            modelMap.addAttribute("message", "Total <b>" + subscriptionPlans.size() + "</b> subscription plans found.");
            return "plan-list";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "plan-list";
        }
    }

    @RequestMapping(value = "/subscriptionplan/{plan_id}")
    private String getSubscriptionPlan(ModelMap modelMap, @PathVariable Long plan_id) {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        try {
            subscriptionPlan = subscriptionPlanService.getSubscriptionPlan(plan_id);
            modelMap.addAttribute("plan", subscriptionPlan);
            return "plan-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/subscriptionplan";
        }
    }
}
