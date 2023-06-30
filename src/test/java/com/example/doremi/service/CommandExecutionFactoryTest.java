package com.example.doremi.service;

import com.example.doremi.concrete.CommandExecutionFactory;
import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;
import com.example.doremi.service.impl.AddSubscriptionCommandExecutor;
import com.example.doremi.service.impl.StartSubscriptionCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandExecutionFactoryTest {

    Command command1;
    Command command2;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        command1 = CommandService.getInstance().getCommandFromString("START_SUBSCRIPTION 20-02-2022");
        command2 = CommandService.getInstance().getCommandFromString("ADD_SUBSCRIPTION MUSIC PERSONAL");
    }

    @Test
    public void getExecutorTest() {
        Assertions.assertTrue(CommandExecutionFactory.getExecutor(command1) instanceof StartSubscriptionCommandExecutor);
        Assertions.assertFalse(CommandExecutionFactory.getExecutor(command2) instanceof StartSubscriptionCommandExecutor);
    }


}
