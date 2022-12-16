package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Payment;
import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.service.PaymentService;
import com.simplilearn.fitnessclubautomation.service.SubscriberService;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/payment/add-new")
    private String addPayment(ModelMap modelMap) {
        String[] payment_mode = {
                "Cash",
                "Credit/Debit Card",
                "UPI"
        };
        List<Subscriber> subscribers = subscriberService.getAllSubscribers();
        modelMap.addAttribute("subscribers", subscribers);
        modelMap.addAttribute("payment_mode", payment_mode);
        return "add-payment";
    }

    @RequestMapping(value = "/payment/add", method = RequestMethod.POST)
    private String addPayment(ModelMap modelMap,
                              @RequestParam(value = "payment_amount", required = true) int payment_amount,
                              @RequestParam(value = "payment_mode", required = true) String payment_mode,
                              @RequestParam(value = "payment_subscriber_id", required = true) Long payment_subscriber_id
    ) {
        Subscriber s = subscriberService.getSubscriber(payment_subscriber_id);
        Long planId = s.getSubscriptionPlan().getPlanId();
        int planFees = subscriptionPlanService.getSubscriptionPlan(planId).getPlanFees();
        int paid = s.getSubscriberFeesPaid();
        int total = paid + payment_amount;
        if (total > planFees) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Payment amount exceeding the actual fees limit.");
            return "add-payment";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String payment_date = sdf.format(date);
        Payment payment = new Payment(payment_amount, payment_date, payment_mode, s);
        paymentService.addPayment(payment);
        s.setSubscriberFeesPaid(total);
        subscriberService.addSubscriber(s);
        return "redirect:/payment";
    }

    @RequestMapping(value = "/payment/edit-payment/{payment_id}")
    private String editPayment(ModelMap modelMap, @PathVariable Long payment_id) {
        Payment payment = new Payment();
        try {
            payment = paymentService.getPayment(payment_id);
            modelMap.addAttribute("payment", payment);
            String[] payment_mode = {
                    "Cash",
                    "Credit/Debit Card",
                    "UPI"
            };
            modelMap.addAttribute("payment_mode", payment_mode);
            List<Subscriber> subscribers = subscriberService.getAllSubscribers();
            modelMap.addAttribute("subscribers", subscribers);
            return "edit-payment";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/payment-list";
        }

    }

    @RequestMapping(value = "/payment/edit", method = RequestMethod.POST)
    private String editPayment(ModelMap modelMap,
                               @RequestParam(value = "payment_id", required = true) Long payment_id,
                               @RequestParam(value = "payment_amount", required = true) int payment_amount,
                               @RequestParam(value = "old_payment_amount", required = true) int old_payment_amount,
                               @RequestParam(value = "payment_date", required = true) String payment_date,
                               @RequestParam(value = "payment_mode", required = true) String payment_mode,
                               @RequestParam(value = "payment_subscriber_id", required = true) Long payment_subscriber_id
    ) {
//        System.out.println(payment_id+","+old_payment_amount+","+payment_amount+","+payment_date+","+payment_mode+","+payment_subscriber_id+",");

        Subscriber subscriber = subscriberService.getSubscriber(payment_subscriber_id);
        int old_total = subscriber.getSubscriberFeesPaid() - old_payment_amount;
        int new_total = old_total + payment_amount;
        Long planId = subscriber.getSubscriptionPlan().getPlanId();
        int planFees = subscriptionPlanService.getSubscriptionPlan(planId).getPlanFees();
        if (new_total > planFees) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Payment amount exceeding the actual fees limit.");
            return "edit-payment";
        }
        Payment payment = new Payment(payment_id, payment_amount, payment_date, payment_mode, subscriber);
        paymentService.addPayment(payment);
        return "redirect:/payment";
    }

//    @RequestMapping(value = "/payment/delete/{payment_id}", method = RequestMethod.GET)
//    private Boolean deletePayment(@PathVariable Long payment_id) {
//        try {
//            paymentService.deletePayment(payment_id);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }

    @RequestMapping(value = "/payment")
    private String getAllPayments(ModelMap modelMap) {
        List<Payment> payments = new ArrayList<>();
        try {
            payments = paymentService.getAllPayments();
            modelMap.addAttribute("payments", payments);
            modelMap.addAttribute("message", "Total <b>" + payments.size() + "</b> payment records found.");

        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
        }
        return "payment-list";
    }

    @RequestMapping(value = "/payment/{payment_id}")
    private String getPayment(ModelMap modelMap, @PathVariable Long payment_id) {
        Payment payment = new Payment();
        try {
            payment = paymentService.getPayment(payment_id);
            modelMap.addAttribute("payment", payment);
            return "payment-single";
        } catch (Exception ex) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", ex.getMessage());
            return "redirect:/payment-list";
        }
    }
}
