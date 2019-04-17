package com.mpazi.factory.patient.record.factory;


import com.mpazi.domain.patient.record.Patient;
import com.mpazi.factory.patient.record.factory.PatientFactory;
import org.junit.Assert;
import org.junit.Test;

public class PatientFactoryTest {

    @Test
    public void getPatientTest() {
        String name = "Salomi";
        Patient p= PatientFactory.getPatient("9502 0898 081",name);
        System.out.println(p);
        Assert.assertNotNull(p.getPatientId());

    }
}
