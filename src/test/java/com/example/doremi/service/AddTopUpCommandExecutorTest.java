package com.example.doremi.service;

import com.example.doremi.concrete.CommandExecutionFactory;
import com.example.doremi.constants.Constants;
import com.example.doremi.enums.Plans;
import com.example.doremi.enums.SubscriptionCategory;
import com.example.doremi.exception.InvalidInputException;
import com.example.doremi.model.Command;
import com.example.doremi.model.SubscriptionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.LinkedHashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AddTopUpCommandExecutorTest {

    Command command1;
    CommandExecutor executor;
    private SubscriptionEntity subscriptionEntity;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("ADD_TOPUP FOUR_DEVICE 3");
        executor = CommandExecutionFactory.getExecutor(command1);
        subscriptionEntity = new SubscriptionEntity(
                LocalDate.parse("20-02-2022", Constants.formatter),
                new LinkedHashMap<SubscriptionCategory, Plans>() {{
                    put(SubscriptionCategory.MUSIC, Plans.PERSONAL);
                }},
                null, 0);
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(() -> executor.executeCommand(subscriptionEntity, command1));
    }

    @Test
    public void testSuccessMessage() throws Exception {
        executor.executeCommand(subscriptionEntity, command1);
        assertEquals("", outContent.toString().trim());
    }

}
