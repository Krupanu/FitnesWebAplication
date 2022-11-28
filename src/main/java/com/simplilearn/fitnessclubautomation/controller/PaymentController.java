package com.simplilearn.fitnessclubautomation.controller;

import com.simplilearn.fitnessclubautomation.model.Payment;
import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.service.PaymentService;
import com.simplilearn.fitnessclubautomation.service.SubscriberService;
import com.simplilearn.fitnessclubautomation.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    SubscriberService subscriberService;
    @Autowired
    SubscriptionPlanService subscriptionPlanService;

    @RequestMapping(value = "/payment/add", method = RequestMethod.POST)
    private Payment addPayment(@RequestParam(value = "payment_amount", required = true) int payment_amount,
                               @RequestParam(value = "payment_date", required = true) String payment_date,
                               @RequestParam(value = "payment_mode", required = true) String payment_mode,
                               @RequestParam(value = "payment_subscriber_id", required = true) Long payment_subscriber_id
    ) {
        Subscriber s = subscriberService.getSubscriber(payment_subscriber_id);
        /*Long planId = s.getSubscriptionPlan().getPlanId();
        int planfees = subscriptionPlanService.getSubscriptionPlan(planId).getPlanFees();
        int paid = s.getSubscriberFeesPaid();
        int total = paid + payment_amount;
        if (total > planfees) {}*/
        Payment payment = new Payment(payment_amount, payment_date, payment_mode, s);
        return paymentService.addPayment(payment);
    }

    @RequestMapping(value = "/payment/edit", method = RequestMethod.POST)
    private Payment editPayment(@RequestParam(value = "payment_id", required = true) Long payment_id,
                                @RequestParam(value = "payment_amount", required = true) int payment_amount,
                                @RequestParam(value = "payment_date", required = true) String payment_date,
                                @RequestParam(value = "payment_mode", required = true) String payment_mode,
                                @RequestParam(value = "payment_subscriber_id", required = true) Long payment_subscriber_id
    ) {
        Subscriber subscriber = subscriberService.getSubscriber(payment_subscriber_id);
        Payment payment = new Payment(payment_id, payment_amount, payment_date, payment_mode, subscriber);
        return paymentService.addPayment(payment);
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
    private List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        try {
            payments = paymentService.getAllPayments();
            return payments;
        } catch (Exception ex) {
            return payments;
        }
    }

    @RequestMapping(value = "/payment/{payment_id}")
    private Payment getPayment(@PathVariable Long payment_id) {
        Payment payment = new Payment();
        try {
            payment = paymentService.getPayment(payment_id);
            return payment;
        } catch (Exception ex) {
            return payment;
        }
    }
}
