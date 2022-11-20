package com.example.doremi.service;

import com.example.doremi.entity.SubscriptionEntity;

public class Service {

    private static SubscriptionEntity subscriptionEntity = new SubscriptionEntity();

    public static void startSubscription(String date){
        subscriptionEntity.setStartDate(date);
    }



}
