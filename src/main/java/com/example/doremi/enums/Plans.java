package com.example.doremi.enums;

public enum Plans {
    FREE("FREE", 0),
    PERSONAL("PERSONAL", 1),
    PREMIUM("PREMIUM", 3);

    public final String name;
    public final int months;

    private Plans(String name, int months) {
        this.name = name;
        this.months = months;
    }
}
