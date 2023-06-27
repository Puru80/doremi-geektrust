package com.example.doremi.concrete;

import com.example.doremi.entity.SubscriptionEntity;
import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

public class Controller {

    private final String controllerName;
    private final SubscriptionEntity subscriptionEntity;

    public Controller(String name, SubscriptionEntity subscriptionEntity) {
        this.controllerName = name;
        this.subscriptionEntity = subscriptionEntity;
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
//        try {
            commandExecutor.executeCommand(subscriptionEntity, inputCommand);
        /*} catch (CourseFullException e) {
            System.out.println(e.getMessage());
        }*/
    }

}
