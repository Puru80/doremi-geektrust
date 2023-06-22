package com.example.doremi.concrete;

import com.example.doremi.model.SubscriptionPOJO;

import java.util.Map;

public class Controller {

    private final String controllerName;
    private final Map<String, SubscriptionPOJO> subscriptionMap;

    public Controller(String name, Map<String, SubscriptionPOJO> subscriptionMap) {
        this.controllerName = name;
        this.subscriptionMap = subscriptionMap;

    }

    /*public static void route(String[] commands){
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
    }*/

}
