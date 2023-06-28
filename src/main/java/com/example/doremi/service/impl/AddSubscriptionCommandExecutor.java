package com.example.doremi.service.impl;

import com.example.doremi.exception.AddSubscriptionFailedException;
import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.time.DateTimeException;
import java.util.List;
import java.util.Map;

public class AddSubscriptionCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) throws Exception {
        if (subscriptionEntity.getStartDate() == null) {
            throw new AddSubscriptionFailedException("INVALID_DATE");
        }

        Map.Entry<SubscriptionCategory, Plans> subscription = getSubscription(command.getCommandParams());

        if (subscriptionEntity.getSubscriptions().containsKey(subscription.getKey())) {
            throw new AddSubscriptionFailedException("DUPLICATE_CATEGORY");
        }

        subscriptionEntity.getSubscriptions().put(subscription.getKey(), subscription.getValue());

    }

    private Map.Entry<SubscriptionCategory, Plans> getSubscription(List<String> commandParams) {
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
