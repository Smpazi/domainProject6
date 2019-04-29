package com.mpazi.factory;

import com.mpazi.domain.Prescription;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrescriptionFactoryTest {

    @Test
    public void getPrescriptionTest(){
        Prescription prescription =PrescriptionFactory.getPrescription("get meds from any pharmacy");

        assertEquals("get meds from any pharmacy",prescription.getPrescriptionAdvice());
    }

}