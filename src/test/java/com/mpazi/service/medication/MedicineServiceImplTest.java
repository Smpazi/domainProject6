package com.mpazi.service.medication;

import com.mpazi.domain.medication.Medicine;
import com.mpazi.factory.medication.factory.MedicineFactory;
import com.mpazi.repository.medication.MedicineRepository;
import com.mpazi.repository.medication.impl.MedicineRepositoryImpl;
import com.mpazi.service.medication.impl.MedicineServiceImpl;
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
public class MedicineServiceImplTest {
    Map<String, String> values;
    private MedicineService service;
    private Medicine medicine;

    @Before
    public void setUp() throws Exception {
        this.service = MedicineServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Med_ID","8989");
        values.put("Medicine_CreatedAt","Clicks pharmacy");
        values.put("Medicine_GenricName","MistAlba");


        this.medicine = MedicineFactory.getMedicine(values);

    }

    @Test
    public void create() {
        Medicine created = this.service.create(medicine);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.medicine);

    }
    @Test
    public void read() {
        Medicine appoint = new Medicine.Builder()
                .med_ID(values.get("Med_ID"))
                .medicine_createdAt(values.get("Medicine_CreatedAt"))
                .medicine_genricName(values.get("Medicine_GenricName"))
                .build();
        service.create(appoint);
        Medicine read = service.read("8989");
        assertEquals("Clicks pharmacy",read.getMedicine_createdAt());
        System.out.println("In read, read = " +read.getMedicine_createdAt() );
    }
    @Test
    public void update()  {
        Medicine med = new Medicine.Builder()
                .med_ID(values.get("Med_ID"))
                .medicine_createdAt(values.get("Medicine_CreatedAt"))
                .medicine_genricName("Vemox")
                .build();
        service.update(med);
        Medicine updated = service.read("8989");
        assertEquals("Vemox",updated.getMedicine_genricName());
    }


    @Test
    public void delete() {

        this.service.delete("8989");
        Medicine notification= service.read("8989");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String, Medicine> all = this.service.getAll();
        System.out.println(all);
    }
}