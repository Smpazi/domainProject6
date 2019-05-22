package com.mpazi.service.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.factory.medication.factory.MedicationFactory;
import com.mpazi.repository.medication.MedicationRepository;
import com.mpazi.repository.medication.impl.MedicationRepositoryImpl;
import com.mpazi.service.medication.impl.MedicationServiceImpl;
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
public class MedicationServiceImplTest {
    Map<String, String> values;
    private MedicationService service;
    private Medication medication;

    @Before
    public void setUp() throws Exception {
        this.service = MedicationServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Med_ID","AB222");
        values.put("Medication_Name","Flutex");

        this.medication = MedicationFactory.getMedication(values);

    }

    @Test
    public void create() {
        Medication created = this.service.create(medication);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.medication);

    }
    @Test
    public void read() {
        Medication medication = new Medication.Builder()
                .med_Id(values.get("Med_ID"))
                .med_Name(values.get("Medication_Name"))
                .build();
        service.create(medication);
        Medication read = service.read("AB222");
        assertEquals("Flutex",read.getMed_Name());

        System.out.println("In read, read = " +read.getMed_Name() );
    }
    @Test
    public void update()  {
        Medication medication = new Medication.Builder()
                .med_Id(values.get("Med_ID"))
                .med_Name("BRUFINE")
                .build();
        service.update(medication);
        Medication updated = service.read("AB222");
        assertEquals("BRUFINE",updated.getMed_Name());
    }


    @Test
    public void delete() {

        this.service.delete("AB222");
        Medication medication= service.read("AB222");
        assertNull(medication);

    }

    @Test
    public void  getAll(){
        Map<String, Medication> all = this.service.getAll();
        System.out.println(all);
    }

}