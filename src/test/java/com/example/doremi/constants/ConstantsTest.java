package com.example.doremi.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ConstantsTest {

    @Test
    public void testGetValue(){
        assertEquals("START_SUBSCRIPTION",Constants.getValue("START_SUBSCRIPTION") );
        assertNotEquals("ADD_SUBSCRIPTION",Constants.getValue("ADD-SUBSCRIPTION"));
        assertEquals("ADD_TOPUP", Constants.getValue("ADD_TOPUP"));
        assertEquals("PRINT_RENEWAL_DETAILS", Constants.getValue("PRINT_RENEWAL_DETAILS"));
    }

}
