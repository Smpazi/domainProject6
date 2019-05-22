package com.mpazi.service.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.factory.information.factory.PatientFactory;
import com.mpazi.repository.information.PatientRepository;
import com.mpazi.repository.information.impl.PatientRepositoryImpl;
import com.mpazi.service.information.impl.PatientServiceImpl;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PatientServiceImplTest {
    Map<String,String> values;
    PatientService service;

    private Patient patient;
    @Before
    public void setUp() throws Exception {
        service = PatientServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("patientId","333A");
        values.put("patientName","Salomi");

        this.patient = PatientFactory.getPatient(values,24);

    }

    @Test
    public void create(){
        Patient created = this.service.create(patient);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.patient);
    }

    @Test
    public void read()  {
        Patient newPatient = new Patient.Builder()
                .patientId(values.get("patientId"))
                .patientName(values.get("patientName"))
                .age(25)
                .build();
        service.create(newPatient);
        Patient read = service.read("333A");
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
        this.service.update(newPatient);
        Patient updatePatient= service.read("333A");
        Assert.assertEquals("ASANDA", updatePatient.getPatientName());

    }

    @Test
    public void delete() throws Exception{
        service.delete("333A");
        patient= service.read("333A");
        assertNull(patient);
    }



}