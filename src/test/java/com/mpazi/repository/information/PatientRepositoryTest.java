package com.mpazi.repository.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.factory.information.factory.PatientFactory;
import com.mpazi.repository.information.impl.PatientRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PatientRepositoryTest {
    Map<String,String> values;
    PatientRepository repository;

    private Patient patient;
    @Before
    public void setUp() throws Exception {
        repository = PatientRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("patientId","333A");
        values.put("patientName","Salomi");

        this.patient = PatientFactory.getPatient(values,24);

    }

    @Test
    public void create(){
        Patient created = this.repository.create(patient);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.patient);
    }

    @Test
    public void read()  {
        Patient newPatient = new Patient.Builder()
                .patientId(values.get("patientId"))
                .patientName(values.get("patientName"))
                .age(25)
                .build();
        repository.create(newPatient);
        Patient read = repository.read("333A");
        Assert.assertEquals("Salomi", read.getPatientName());

        System.out.println("In read, read = " + read.getPatientName());
    }

    @Test
    public void update() {
        Patient newPatient = new Patient.Builder()
                .patientId(values.get("patientId"))
                .patientName("ASANDA")
                .age(25)
                .build();
        this.repository.update(newPatient);
        Patient updatePatient= repository.read("333A");
        Assert.assertEquals("ASANDA", updatePatient.getPatientName());

    }

    @Test
    public void delete() throws Exception{
        repository.delete("333A");
        patient= repository.read("333A");
        assertNull(patient);
    }



}