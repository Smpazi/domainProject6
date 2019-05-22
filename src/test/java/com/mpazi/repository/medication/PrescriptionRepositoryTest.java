package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.medication.factory.PrescriptionFactory;
import com.mpazi.repository.medication.impl.PrescriptionRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class PrescriptionRepositoryTest {

    Map<String, String> values;
    private PrescriptionRepository repository;
    private Prescription prescription;

    @Before
    public void setUp() throws Exception {
        this.repository = PrescriptionRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Prescription_ID","pre444");
        values.put("VisitTime","10:20:00");

        this.prescription = PrescriptionFactory.getPrescription(values);

    }

    @Test
    public void create() {
        Prescription created = this.repository.create(prescription);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.prescription);

    }
    @Test
    public void read() {
        Prescription appoint = new Prescription.Builder()
                .prescriptionId(values.get("Prescription_ID"))
                .visitTime(values.get("VisitTime"))
                .build();
        repository.create(appoint);
        Prescription read = repository.read("pre444");
        assertEquals("10:20:00",read.getVisitTime());

        System.out.println("In read, read = " +read.getVisitTime() );
    }
    @Test
    public void update()  {
        Prescription prescription = new Prescription.Builder()
                .prescriptionId(values.get("Prescription_ID"))
                .visitTime("10:30:00")
                .build();
        repository.update(prescription);
        Prescription updated = repository.read("pre444");
        assertEquals("10:30:00",updated.getVisitTime());
    }


    @Test
    public void delete() {

        this.repository.delete("pre444");
        Prescription notification= repository.read("pre444");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String,Prescription> all = this.repository.getAll();
        System.out.println(all);
    }

}