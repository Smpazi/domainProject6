package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.MedicalHistory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MedicalHistoryFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Patient_Allegies","antibiotics");
        //    values.put("CheckUpDescription","23/April/2011");

    }
    @Test
    public void getMedicalHistoryTest() {

        MedicalHistory medicalHistory = MedicalHistoryFactory.getMedicalHistory(values);

        Assert.assertEquals("antibiotics",medicalHistory.getAllegies());

    }
}