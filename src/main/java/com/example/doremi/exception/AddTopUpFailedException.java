package com.example.doremi.exception;

import com.example.doremi.constants.Constants;

public class AddTopUpFailedException extends Exception{

    public AddTopUpFailedException(String msg){
        super(Constants.ExceptionMessages.ADD_TOPUP_FAILED + " " + msg);
    }

}
