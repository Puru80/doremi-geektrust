package com.example.doremi.enums;

public enum Plans {
    FREE("Free", 0),
    PERSONAL("Personal", 1),
    PREMIUM("Premium", 3);

    public final String name;
    public final int months;

    private Plans(String name, int months) {
        this.name = name;
        this.months = months;
    }
}
