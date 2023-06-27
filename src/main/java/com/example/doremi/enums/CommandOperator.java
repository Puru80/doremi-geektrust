package com.example.doremi.enums;

public enum CommandOperator {
    START_SUBSCRIPTION(1), //SUBSCRIPTION_START_DATE
    ADD_SUBSCRIPTION(2), //SUBSCRIPTION_NAME PLAN_NAME
    ADD_TOPUP(2), //TOP_UP_NAME NO_OF_MONTHS
    PRINT_RENEWAL_DETAILS(0); //NO_ARGS

    CommandOperator(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}
