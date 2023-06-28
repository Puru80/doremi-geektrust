package com.example.doremi.service.impl;

import com.example.doremi.exception.AddTopUpFailedException;
import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.enums.TopUp;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.util.List;

public class AddTopUpCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) throws Exception{
        if (subscriptionEntity.getStartDate() == null) {
            throw new AddTopUpFailedException("INVALID_DATE");
        }

        if (subscriptionEntity.getSubscriptions().isEmpty()) {
            throw new AddTopUpFailedException("SUBSCRIPTIONS_NOT_FOUND");
        }

        if (subscriptionEntity.getTopUp() != null) {
            throw new AddTopUpFailedException("DUPLICATE_TOPUP");
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
