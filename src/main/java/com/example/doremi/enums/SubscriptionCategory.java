package com.example.doremi.enums;

public enum SubscriptionCategory {
    MUSIC("MUSIC", 100, 250),
    VIDEO("VIDEO", 200, 500),
    PODCAST("PODCAST", 100, 300);

    public final String name;
    public final int personal;
    public final int premium;

    private SubscriptionCategory(String name, int personal, int premium) {
            this.name = name;
        this.personal = personal;
        this.premium = premium;
    }
}
