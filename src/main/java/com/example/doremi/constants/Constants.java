package com.example.doremi.constants;

import java.time.format.DateTimeFormatter;

public class Constants {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static class ExceptionMessages {
        public static final String ADD_SUBSCRIPTION_FAILED = "ADD_SUBSCRIPTION_FAILED";
        public static final String ADD_TOPUP_FAILED = "ADD_TOPUP_FAILED";
        public static final String SUBSCRIPTIONS_NOT_FOUND = "SUBSCRIPTIONS_NOT_FOUND";
    }

    public static String getValue(String input) {
        String value = "";
        switch (input) {
            case "START_SUBSCRIPTION":
                value = "START_SUBSCRIPTION";
                break;

            case "ADD_SUBSCRIPTION":
                value = "ADD_SUBSCRIPTION";
                break;

            case "ADD_TOPUP":
                value = "ADD_TOPUP";
                break;

            case "PRINT_RENEWAL_DETAILS":
                value = "PRINT_RENEWAL_DETAILS";
                break;

            default:
                value = input;
                break;
        }
        return value;
    }

}
