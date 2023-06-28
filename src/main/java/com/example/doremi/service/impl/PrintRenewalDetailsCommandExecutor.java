package com.example.doremi.service.impl;

import com.example.doremi.constants.Constants;
import com.example.doremi.exception.SubscriptionNotFoundException;
import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.util.Map;

public class PrintRenewalDetailsCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) throws Exception {

        if (subscriptionEntity.getSubscriptions().isEmpty()) {
            throw new SubscriptionNotFoundException();
        }

        renewalReminder(subscriptionEntity);
        renewalAmount(subscriptionEntity);

    }

    private void renewalReminder(SubscriptionEntity subscriptionEntity) {
        for (Map.Entry<SubscriptionCategory, Plans> entry : subscriptionEntity.getSubscriptions().entrySet()) {
            System.out.println("RENEWAL_REMINDER" + " " + entry.getKey().name + " " +
                    subscriptionEntity.getStartDate()
                            .plusMonths(entry.getValue().months).minusDays(10).format(Constants.formatter));
        }
    }

    private void renewalAmount(SubscriptionEntity subscriptionEntity) {
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
