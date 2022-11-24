package com.simplilearn.fitnessclubautomation.service;

import com.simplilearn.fitnessclubautomation.model.Subscriber;
import com.simplilearn.fitnessclubautomation.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    SubscriberRepository subscriberRepository;

    public Subscriber addSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public void deleteSubscriber(Long subscriber_id) {
        subscriberRepository.deleteById(subscriber_id);
    }

    public List<Subscriber> getAllSubscribers() {
        List<Subscriber> subscribers = new ArrayList<>();
        subscriberRepository.findAll().forEach(subscribers::add);
        return subscribers;
    }

    public Subscriber getSubscriber(Long subscriber_id) {
        return subscriberRepository.findById(subscriber_id).get();
    }
}
