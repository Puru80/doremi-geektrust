package com.example.doremi.entity;

import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.enums.TopUp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class SubscriptionEntity {

    private LocalDate startDate;
    private Map<SubscriptionCategory, Plans> subscriptions = new LinkedHashMap<>();
    private TopUp topUp;
    private int topUpTime;
}
