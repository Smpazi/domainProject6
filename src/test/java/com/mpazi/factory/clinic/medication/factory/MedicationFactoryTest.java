package com.mpazi.factory.clinic.medication.factory;

import com.mpazi.domain.clinic.medication.Medication;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicationFactoryTest {

    @Test
    public void getMedicationTest(){

        Medication medication= MedicationFactory.getMedication("Panado");

        assertEquals("Panado",medication.getMed_Name());

    }

}