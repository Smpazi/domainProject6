package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MedicationFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Medication_Name","Painkiller");

    }
    @Test
    public void getMedicationTest() {

        Medication medication= MedicationFactory.getMedication(values);

        Assert.assertEquals("Painkiller",medication.getMed_Name());

    }
}