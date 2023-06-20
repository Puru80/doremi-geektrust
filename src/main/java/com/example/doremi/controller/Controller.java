package com.example.doremi.controller;

import com.example.doremi.enums.CommandOperator;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.enums.TopUp;
import com.example.doremi.service.Service;

public class Controller {

    public static void route(String[] commands){
        String command = commands[0];

        CommandOperator command1 = CommandOperator.valueOf(command);

        switch (command1){
            case START_SUBSCRIPTION:
                Service.startSubscription(commands[1]);
                break;
            case ADD_SUBSCRIPTION:
                SubscriptionCategory subscriptionCategory = SubscriptionCategory.valueOf(commands[1]);
                Plans plans = Plans.FREE.valueOf(commands[2]);

                Service.addSubscriptionCategory(subscriptionCategory, plans);
                break;
            case ADD_TOPUP:
                TopUp topUp = TopUp.valueOf(commands[1]);
                int time = Integer.parseInt(commands[2]);

                Service.addTopUp(topUp, time);
                break;
            case PRINT_RENEWAL_DETAILS:
                Service.printRenewalDetails();
                break;
        }
    }

}
