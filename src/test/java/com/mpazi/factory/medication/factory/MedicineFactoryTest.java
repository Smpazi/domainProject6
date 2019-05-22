package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medicine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MedicineFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Medicine_CreatedAt","Clicks Factory");

    }
    @Test
    public void getMedicineTest() {

        Medicine medicine=  MedicineFactory.getMedicine(values);

        Assert.assertEquals("Clicks Factory",medicine.getMedicine_createdAt());

    }
}