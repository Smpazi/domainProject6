package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medicine;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicineFactoryTest {

    @Test
    public void getMedicineTest(){
        Medicine medicine= MedicineFactory.getMedicine("clicksPhamacy");

        assertEquals("clicksPhamacy",medicine.getMedicine_createdAt());
    }

}