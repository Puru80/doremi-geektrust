package com.example.doremi.exception;

import com.example.doremi.constants.Constants;

public class SubscriptionNotFoundException extends Exception{

    public SubscriptionNotFoundException(){
        super(Constants.ExceptionMessages.SUBSCRIPTIONS_NOT_FOUND);
    }

}
