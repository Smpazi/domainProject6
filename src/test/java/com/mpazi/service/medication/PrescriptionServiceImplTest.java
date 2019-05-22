package com.mpazi.service.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.medication.factory.PrescriptionFactory;
import com.mpazi.repository.medication.PrescriptionRepository;
import com.mpazi.repository.medication.impl.PrescriptionRepositoryImpl;
import com.mpazi.service.medication.impl.PrescriptionServiceImpl;
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
public class PrescriptionServiceImplTest {

    Map<String, String> values;
    private PrescriptionService service;
    private Prescription prescription;

    @Before
    public void setUp() throws Exception {
        this.service = PrescriptionServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Prescription_ID","pre444");
        values.put("VisitTime","10:20:00");

        this.prescription = PrescriptionFactory.getPrescription(values);

    }

    @Test
    public void create() {
        Prescription created = this.service.create(prescription);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.prescription);

    }
    @Test
    public void read() {
        Prescription appoint = new Prescription.Builder()
                .prescriptionId(values.get("Prescription_ID"))
                .visitTime(values.get("VisitTime"))
                .build();
        service.create(appoint);
        Prescription read = service.read("pre444");
        assertEquals("10:20:00",read.getVisitTime());

        System.out.println("In read, read = " +read.getVisitTime() );
    }
    @Test
    public void update()  {
        Prescription prescription = new Prescription.Builder()
                .prescriptionId(values.get("Prescription_ID"))
                .visitTime("10:30:00")
                .build();
        service.update(prescription);
        Prescription updated = service.read("pre444");
        assertEquals("10:30:00",updated.getVisitTime());
    }


    @Test
    public void delete() {

        this.service.delete("pre444");
        Prescription notification= service.read("pre444");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String,Prescription> all = this.service.getAll();
        System.out.println(all);
    }

}