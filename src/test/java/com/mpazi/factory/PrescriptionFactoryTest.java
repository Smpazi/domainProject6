package com.mpazi.factory;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.other.factory.PrescriptionFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrescriptionFactoryTest {

    @Test
    public void getPrescriptionTest(){
        Prescription prescription = PrescriptionFactory.getPrescription("get meds from any pharmacy");

        assertEquals("get meds from any pharmacy",prescription.getPrescriptionAdvice());
    }

}