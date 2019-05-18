package com.mpazi.repository.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.factory.information.factory.PatientFactory;
import com.mpazi.repository.information.impl.PatientRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PatientRepositoryTest {
    Map<String,String> values;
    PatientRepository repository;

    Patient patient;
    @Before
    public void setUp() throws Exception {
        repository = PatientRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("patientId","333A");
        values.put("patientName","Salomi");
    }

    @Test
    public void create() throws Exception{
       Patient patient= PatientFactory.getPatient(values,24);
        repository.create(patient);
        assertEquals(24,patient.getAge());
    }

    @Test
    public void read() throws Exception {
        patient = repository.read("333A");
        assertEquals("333A",patient.getPatientId());
    }

    @Test
    public void update() throws Exception{
        patient= repository.read("333A");
        Patient newPatient = new Patient.Builder()
                .patientId(values.get("patientId"))
                .patientName(values.get("patientName"))
                .age(25)
                .build();
        repository.update(newPatient);
        Patient updatePatient= repository.read("333A");
        assertEquals(0,updatePatient.getAge());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("333A");
        patient= repository.read("333A");
        assertNull(patient);
    }



}