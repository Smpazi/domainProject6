package com.mpazi.factory.record.factory;


import com.mpazi.domain.patient.record.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PatientFactoryTest {

    Map<String,String> values;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("patientId", "333A");
        values.put("patientName","Salomi");
    }

    @Test
    public void getPatientTest() {

        Patient p= PatientFactory.getPatient(values,23);
        System.out.println(p);
        Assert.assertNotNull(p.getPatientId());

    }
}
