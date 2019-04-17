package com.mpazi.factory.clinic.medication.factory;

import com.mpazi.domain.clinic.medication.Pill;
import org.junit.Test;

import static org.junit.Assert.*;

public class PillFactoryTest {
    @Test
    public void getPillTest(){
        Pill pill= PillFactory.getPill(12);

        assertEquals(12,pill.getPillQuantity());


    }

}