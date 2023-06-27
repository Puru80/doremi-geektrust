package com.example.doremi.service;

import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.model.Command;


public interface CommandExecutor {

    void executeCommand(SubscriptionEntity subscriptionEntity, Command command);
}
