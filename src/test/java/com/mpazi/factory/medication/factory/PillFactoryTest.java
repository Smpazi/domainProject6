package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Pill;
import org.junit.Test;

import static org.junit.Assert.*;

public class PillFactoryTest {
    @Test
    public void getPillTest(){
        Pill pill= PillFactory.getPill(12);

        assertEquals(12,pill.getPillQuantity());


    }

}