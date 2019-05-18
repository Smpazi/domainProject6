package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.medication.factory.PrescriptionFactory;
import org.junit.Test;

public class PrescriptionFactoryTest {

    @Test
    public void getPrescriptionTest(){
        Prescription prescription = PrescriptionFactory.getPrescription("get meds from any pharmacy");

        assertEquals("get meds from any pharmacy",prescription.getPrescriptionAdvice());
    }

}