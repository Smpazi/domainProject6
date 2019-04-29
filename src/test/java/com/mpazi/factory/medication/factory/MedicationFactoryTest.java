package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medication;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicationFactoryTest {

    @Test
    public void getMedicationTest(){

        Medication medication= MedicationFactory.getMedication("Panado");

        assertEquals("Panado",medication.getMed_Name());

    }

}