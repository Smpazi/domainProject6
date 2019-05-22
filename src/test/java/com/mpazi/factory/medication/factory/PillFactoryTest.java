package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Pill;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PillFactoryTest {
    Map<String, String> values;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("pill_ID","889");


    }
    @Test
    public void getPillTest(){
        Pill pill= PillFactory.getPill(values,12);

        assertEquals(12,pill.getPillQuantity());


    }

}