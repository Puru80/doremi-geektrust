package com.example.doremi.enums;

public enum TopUp {
    FOUR_DEVICE(4, 50),
    TEN_DEVICE(10, 100);

    public final int numOfDevices;
    public final int cost;

    private TopUp(int numOfDevices, int cost) {
        this.numOfDevices = numOfDevices;
        this.cost = cost;
    }
}
