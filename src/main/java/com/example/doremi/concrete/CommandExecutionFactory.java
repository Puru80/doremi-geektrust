package com.example.doremi.concrete;

import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;
import com.example.doremi.service.impl.AddSubscriptionCommandExecutor;
import com.example.doremi.service.impl.AddTopUpCommandExecutor;
import com.example.doremi.service.impl.PrintRenewalDetailsCommandExecutor;
import com.example.doremi.service.impl.StartSubscriptionCommandExecutor;

public class CommandExecutionFactory {

    public static CommandExecutor getExecutor(Command task) {
        CommandExecutor executor = null;
        if (task != null) {
            switch (task.getInputCommand()) {
                case START_SUBSCRIPTION:
                    executor = new StartSubscriptionCommandExecutor();
                    break;
                case ADD_SUBSCRIPTION:
                    executor = new AddSubscriptionCommandExecutor();
                    break;
                case ADD_TOPUP:
                    executor = new AddTopUpCommandExecutor();
                    break;
                case PRINT_RENEWAL_DETAILS:
                    executor = new PrintRenewalDetailsCommandExecutor();
                    break;
                default:
                    break;
            }
        }

        return executor;
    }
}
