package com.example.doremi.service.impl;

import com.example.doremi.entity.SubscriptionEntity;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.util.Map;

public class PrintRenewalDetailsCommanExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) {
        int amount = 0;
        for (Map.Entry<SubscriptionCategory, Plans> entry : subscriptionEntity.getSubscriptions().entrySet()) {
            if (entry.getValue().equals(Plans.PERSONAL)) {
                amount += entry.getKey().personal;
            } else if (entry.getValue().equals(Plans.PREMIUM)) {
                amount += entry.getKey().premium;
            }
        }

        if (subscriptionEntity.getTopUp() != null)
            amount += subscriptionEntity.getTopUpTime() * subscriptionEntity.getTopUp().cost;

        System.out.println("RENEWAL_AMOUNT " + amount);
    }

}
