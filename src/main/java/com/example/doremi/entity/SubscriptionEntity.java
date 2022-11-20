package com.example.doremi.entity;

import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.enums.TopUp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class SubscriptionEntity {

    private String startDate;
    private Map<SubscriptionCategory, Plans> subscriptions;
    private TopUp topUp;
}
