package com.example.doremi.concrete;

import com.example.doremi.model.Command;
import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.service.CommandExecutor;

public class Controller {

    private final String controllerName;
    private final SubscriptionEntity subscriptionEntity;

    public Controller(String name) {
        this.controllerName = name;
        this.subscriptionEntity = new SubscriptionEntity();
    }

    public void fulfillCommand(Command inputCommand) {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try {
            commandExecutor.executeCommand(subscriptionEntity, inputCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
