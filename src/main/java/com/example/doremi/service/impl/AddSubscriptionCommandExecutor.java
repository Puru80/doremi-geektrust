package com.example.doremi.service.impl;

import com.example.doremi.entity.SubscriptionEntity;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.util.List;
import java.util.Map;

public class AddSubscriptionCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) {
        if (subscriptionEntity.getStartDate() == null) {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
            return;
        }

        Map.Entry<SubscriptionCategory, Plans> subscription = getSubscription(command.getCommandParams());

        if (subscriptionEntity.getSubscriptions().containsKey(subscription.getKey())) {
            System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            return;
        }

        subscriptionEntity.getSubscriptions().put(subscription.getKey(), subscription.getValue());

    }

    private Map.Entry<SubscriptionCategory, Plans> getSubscription(List<String> commandParams){
        SubscriptionCategory subscriptionCategory = SubscriptionCategory.valueOf(commandParams.get(0));
        Plans plans = Plans.valueOf(commandParams.get(1));

        return new Map.Entry<SubscriptionCategory, Plans>() {
            @Override
            public SubscriptionCategory getKey() {
                return subscriptionCategory;
            }

            @Override
            public Plans getValue() {
                return plans;
            }

            @Override
            public Plans setValue(Plans value) {
                return null;
            }
        };

    }

}
