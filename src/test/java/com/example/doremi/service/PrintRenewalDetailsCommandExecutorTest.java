package com.example.doremi.service;

import com.example.doremi.concrete.CommandExecutionFactory;
import com.example.doremi.model.Command;
import com.example.doremi.model.SubscriptionEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PrintRenewalDetailsCommandExecutorTest {

    Command command1;
    CommandExecutor executor;
    private SubscriptionEntity subscriptionEntity;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("PRINT_RENEWAL_DETAILS");
        executor = CommandExecutionFactory.getExecutor(command1);
        subscriptionEntity = new SubscriptionEntity();
    }

    @Test
    public void testExecute() throws Exception {
        assertDoesNotThrow(() -> executor.executeCommand(subscriptionEntity, command1));
    }

    @Test
    public void testSuccessMessage() throws Exception {
        executor.executeCommand(subscriptionEntity, command1);
        assertEquals("", outContent.toString().trim());
    }

}
