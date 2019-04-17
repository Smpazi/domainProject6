package com.mpazi.factory;

import com.mpazi.domain.DrugPrescription;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrugPrescriptionFactoryTest {
    @Test
    public void getDrugPrescriptionTest(){
        DrugPrescription drugPrescription =DrugPrescriptionFactory.getDrugPrescription(324,"B co");

        assertEquals("B co", (drugPrescription.getDrugName()));
    }

}