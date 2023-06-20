package com.example.doremi.enums;

public enum CommandOperator {
    START_SUBSCRIPTION(1),
    ADD_SUBSCRIPTION(2), // SUBSCRIPTION_CATEGORY PLAN_NAME
    ADD_TOPUP(2), //TOP_UP_NAME NO_OF_MONTHS
    PRINT_RENEWAL_DETAILS(0);

    CommandOperator(Integer numArgs){
        this.numberOfArguments = numArgs;
    }

    private final Integer numberOfArguments;

    public Integer getNumberOfArguments() {
        return numberOfArguments;
    }
}
