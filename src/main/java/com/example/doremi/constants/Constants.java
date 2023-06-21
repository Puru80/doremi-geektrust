package com.example.doremi.constants;

public class Constants {

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
