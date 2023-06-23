package com.example.doremi.constants;

public class Constants {

    //static Class for Music subscription category
    public static class Music {
        public static final String name = "MUSIC";
        public static final int personal = 100;
        public static final int premium = 250;
    }

    //static Class for Video subscription category
    public static class Video {
        public static final String name = "VIDEO";
        public static final int personal = 200;
        public static final int premium = 500;
    }

    //static Class for Podcast subscription category
    public static class Podcast {
        public static final String name = "PODCAST";
        public static final int personal = 100;
        public static final int premium = 300;
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
