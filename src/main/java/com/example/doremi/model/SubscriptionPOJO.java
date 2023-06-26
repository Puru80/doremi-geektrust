package com.example.doremi.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class SubscriptionPOJO {

    private String name;
    private LocalDate startDate;
    private String subscriptionPlan;

    public SubscriptionPOJO(LocalDate startDate) {
        this.startDate = startDate;
    }
}
