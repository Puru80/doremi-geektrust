package com.example.doremi.service.impl;

import com.example.doremi.model.Command;
import com.example.doremi.service.CommandExecutor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StartSubscriptionCommandExecutor implements CommandExecutor {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void executeCommand(Command command) {
        List<String> params = command.getCommandParams();

        LocalDate startDate = LocalDate.parse(params.get(0), formatter);

//        subscriptionEntity.setStartDate(LocalDate.parse(startDate.format(formatter), formatter));
    }



}
