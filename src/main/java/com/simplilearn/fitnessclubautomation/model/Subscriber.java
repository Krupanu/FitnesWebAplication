package com.simplilearn.fitnessclubautomation.model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_subscriber")
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscriber_id", nullable = false)
    private Long subscriberId;
    @Column(name = "subscriber_name", nullable = false)
    private String subscriberName;
    @Column(name = "subscriber_age", nullable = false)
    private int subscriberAge;
    @Column(name = "subscriber_gender", nullable = false)
    private String subscriberGender;
    @Column(name = "subscriber_address", nullable = false)
    private String subscriberAddress;
    @Column(name = "subscriber_status", nullable = false)
    private boolean subscriberStatus;

    public Subscriber() {
    }

    public Subscriber(Long subscriberId, String subscriberName, int subscriberAge, String subscriberGender, String subscriberAddress, boolean subscriberStatus) {
        this.subscriberId = subscriberId;
        this.subscriberName = subscriberName;
        this.subscriberAge = subscriberAge;
        this.subscriberGender = subscriberGender;
        this.subscriberAddress = subscriberAddress;
        this.subscriberStatus = subscriberStatus;
    }

    public Long getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(Long subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public int getSubscriberAge() {
        return subscriberAge;
    }

    public void setSubscriberAge(int subscriberAge) {
        this.subscriberAge = subscriberAge;
    }

    public String getSubscriberGender() {
        return subscriberGender;
    }

    public void setSubscriberGender(String subscriberGender) {
        this.subscriberGender = subscriberGender;
    }

    public String getSubscriberAddress() {
        return subscriberAddress;
    }

    public void setSubscriberAddress(String subscriberAddress) {
        this.subscriberAddress = subscriberAddress;
    }

    public boolean isSubscriberStatus() {
        return subscriberStatus;
    }

    public void setSubscriberStatus(boolean subscriberStatus) {
        this.subscriberStatus = subscriberStatus;
    }
}
