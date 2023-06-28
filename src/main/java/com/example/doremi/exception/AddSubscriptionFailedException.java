package com.example.doremi.exception;

import com.example.doremi.constants.Constants;

public class AddSubscriptionFailedException extends Exception{

    public AddSubscriptionFailedException(String msg){
        super(Constants.ExceptionMessages.ADD_SUBSCRIPTION_FAILED + " " + msg);
    }

}
