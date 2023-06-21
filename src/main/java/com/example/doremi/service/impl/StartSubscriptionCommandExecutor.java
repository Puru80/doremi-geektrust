package com.example.doremi.service.impl;

import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

public class StartSubscriptionCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(Command command) {
        System.out.println("StartSubscriptionCommandExecutor.executeCommand");
    }



}
