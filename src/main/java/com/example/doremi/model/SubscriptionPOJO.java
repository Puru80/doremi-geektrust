package com.example.doremi.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SubscriptionPOJO {

    private String name;
    private int personalSubscriptionCost;
    private int premiumSubscriptionCost;

}
