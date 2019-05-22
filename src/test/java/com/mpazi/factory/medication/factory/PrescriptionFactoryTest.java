package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.medication.factory.PrescriptionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PrescriptionFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("VisitTime","10:29:00");

    }
    @Test
    public void getPrescriptionTest() {

        Prescription prescription =PrescriptionFactory.getPrescription(values);

        Assert.assertEquals("10:29:00",prescription.getVisitTime());

    }
}