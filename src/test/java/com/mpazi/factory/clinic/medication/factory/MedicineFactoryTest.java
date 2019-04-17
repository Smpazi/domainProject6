package com.mpazi.factory.clinic.medication.factory;

import com.mpazi.domain.clinic.medication.Medicine;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicineFactoryTest {

    @Test
    public void getMedicineTest(){
        Medicine medicine= MedicineFactory.getMedicine("clicksPhamacy");

        assertEquals("clicksPhamacy",medicine.getMedicine_createdAt());
    }

}