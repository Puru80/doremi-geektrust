package com.example.doremi.service.impl;

import com.example.doremi.constants.Constants;
import com.example.doremi.entity.SubscriptionEntity;
import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StartSubscriptionCommandExecutor implements CommandExecutor {

    @Override
    public void executeCommand(SubscriptionEntity subscriptionEntity, Command command) {
        List<String> params = command.getCommandParams();

        try {
            String date = params.get(0);

            LocalDate startDate = LocalDate.parse(date, Constants.formatter);

            subscriptionEntity.setStartDate(LocalDate.parse(startDate.format(Constants.formatter), Constants.formatter));
        } catch (DateTimeException e) {
            System.out.println("INVALID_DATE");
        }
    }


}
