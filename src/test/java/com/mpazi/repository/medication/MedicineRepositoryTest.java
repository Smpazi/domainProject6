package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Medicine;
import com.mpazi.factory.medication.factory.MedicineFactory;
import com.mpazi.repository.medication.impl.MedicineRepositoryImpl;
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
public class MedicineRepositoryTest {

    Map<String, String> values;
    private MedicineRepository repository;
    private Medicine medicine;

    @Before
    public void setUp() throws Exception {
        this.repository = MedicineRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Med_ID","8989");
        values.put("Medicine_CreatedAt","Clicks pharmacy");
        values.put("Medicine_GenricName","MistAlba");
        this.medicine = MedicineFactory.getMedicine(values);

    }

    @Test
    public void create() {
        Medicine created = this.repository.create(medicine);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.medicine);

    }
    @Test
    public void read() {
        Medicine appoint = new Medicine.Builder()
                .med_ID(values.get("Med_ID"))
                .medicine_createdAt(values.get("Medicine_CreatedAt"))
                .medicine_genricName(values.get("Medicine_GenricName"))
                .build();
        repository.create(appoint);
        Medicine read = repository.read("8989");
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
        repository.update(med);
        Medicine updated = repository.read("8989");
        assertEquals("Vemox",updated.getMedicine_genricName());
    }


    @Test
    public void delete() {

        this.repository.delete("8989");
        Medicine notification= repository.read("8989");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String, Medicine> all = this.repository.getAll();
        System.out.println(all);
    }

}