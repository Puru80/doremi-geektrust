package com.example.doremi.service;

import com.example.doremi.model.SubscriptionEntity;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.enums.TopUp;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Logger;

public class Service {

    public static final Logger logger = Logger.getLogger("Service");
    private static SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //TODO: Error handling to be implemented

    public static void startSubscription(String date) {
        try {
            LocalDate startDate = LocalDate.parse(date, formatter);

            subscriptionEntity.setStartDate(LocalDate.parse(startDate.format(formatter), formatter));
        } catch (DateTimeException e) {
            System.out.println("INVALID_DATE");
        }
    }

    public static void addSubscriptionCategory(SubscriptionCategory subscriptionCategory, Plans plans) {
        if (subscriptionEntity.getStartDate() == null) {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
            return;
        }

        if (subscriptionEntity.getSubscriptions().containsKey(subscriptionCategory)) {
            System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            return;
        }

        subscriptionEntity.getSubscriptions().put(subscriptionCategory, plans);
    }

    public static void addTopUp(TopUp topUp, int months) {
        if (subscriptionEntity.getStartDate() == null) {
            System.out.println("ADD_TOPUP_FAILED INVALID_DATE");
            return;
        }

        if (subscriptionEntity.getSubscriptions().isEmpty()) {
            System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            return;
        }

        if (subscriptionEntity.getTopUp() != null) {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
            return;
        }

        subscriptionEntity.setTopUp(topUp);
        subscriptionEntity.setTopUpTime(months);
    }

    public static void printRenewalDetails() {
        if (subscriptionEntity.getSubscriptions().isEmpty()) {
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
            return;
        }

        renewalReminder();
        renewalAmount();
    }

    private static void renewalReminder() {
        for (Map.Entry<SubscriptionCategory, Plans> entry : subscriptionEntity.getSubscriptions().entrySet()) {
            System.out.println("RENEWAL_REMINDER" + " " + entry.getKey().name + " " +
                    subscriptionEntity.getStartDate()
                            .plusMonths(entry.getValue().months).minusDays(10).format(formatter));
        }
    }

    private static void renewalAmount() {
        int amount = 0;
        for (Map.Entry<SubscriptionCategory, Plans> entry : subscriptionEntity.getSubscriptions().entrySet()) {
            if (entry.getValue().equals(Plans.PERSONAL)) {
                amount += entry.getKey().personal;
            } else if (entry.getValue().equals(Plans.PREMIUM)) {
                amount += entry.getKey().premium;
            }
        }

        if (subscriptionEntity.getTopUp() != null)
            amount += subscriptionEntity.getTopUpTime() * subscriptionEntity.getTopUp().cost;

        System.out.println("RENEWAL_AMOUNT " + amount);

    }

}
