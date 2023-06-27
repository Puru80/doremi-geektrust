package com.example.doremi.service.impl;

import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.enums.TopUp;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.util.List;

public class AddTopUpCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) {
        if (subscriptionEntity.getStartDate() == null) {
            System.out.println("ADD_TOPUP_FAILED INVALID_DATE");
            return;
        }

        if (subscriptionEntity.getSubscriptions().isEmpty()) {
            System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            return;
        }

        if (subscriptionEntity.getTopUp() != null) {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
            return;
        }

        getTopUp(command.getCommandParams(), subscriptionEntity);

    }

    private void getTopUp(List<String> commands, SubscriptionEntity subscriptionEntity) {

        TopUp topUp = TopUp.valueOf(commands.get(0));
        int topUpTime = Integer.parseInt(commands.get(1));

        subscriptionEntity.setTopUp(topUp);
        subscriptionEntity.setTopUpTime(topUpTime);

    }

}
