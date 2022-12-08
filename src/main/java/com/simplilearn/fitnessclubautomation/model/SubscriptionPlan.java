package com.simplilearn.fitnessclubautomation.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_subscriptionplan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id", nullable = false)
    private Long planId;
    @Column(name = "plan_title", nullable = false)
    private String planTitle;
    @Column(name = "plan_duration", nullable = false)
    private int planDuration;
    @Column(name = "plan_fees", nullable = false)
    private int planFees;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(Long planId, String planTitle, int planDuration, int planFees) {
        this.planId = planId;
        this.planTitle = planTitle;
        this.planDuration = planDuration;
        this.planFees = planFees;
    }

    public SubscriptionPlan(String planTitle, int planDuration, int planFees) {
        this.planTitle = planTitle;
        this.planDuration = planDuration;
        this.planFees = planFees;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanTitle() {
        return planTitle;
    }

    public void setPlanTitle(String planTitle) {
        this.planTitle = planTitle;
    }

    public int getPlanDuration() {
        return planDuration;
    }

    public void setPlanDuration(int planDuration) {
        this.planDuration = planDuration;
    }

    public int getPlanFees() {
        return planFees;
    }

    public void setPlanFees(int planFees) {
        this.planFees = planFees;
    }
}
