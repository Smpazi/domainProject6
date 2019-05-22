package com.mpazi.repository.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.factory.information.factory.MedicalHistoryFactory;
import com.mpazi.repository.information.impl.MedicalHistoryRepositoryImpl;
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
public class MedicalHistoryRepositoryImplTest {

    Map<String, String> values;
    private MedicalHistoryRepository repository;
    private MedicalHistory medicalHistory;

    @Before
    public void setUp() throws Exception {
        this.repository = MedicalHistoryRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("MedHistory_ID","7676");
        values.put("Cronical_Desease","Cancer");


        this.medicalHistory = MedicalHistoryFactory.getMedicalHistory(values);

    }

    @Test
    public void create() {
        MedicalHistory created = this.repository.create(medicalHistory);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.medicalHistory);

    }
    @Test
    public void read() {
        MedicalHistory medicalHistory = new MedicalHistory.Builder()
                .medHistory_ID(values.get("MedHistory_ID"))
                .cronical_Desease(values.get("Cronical_Desease"))
                .build();
        repository.create(medicalHistory);
        MedicalHistory read = repository.read("7676");
        assertEquals("Cancer", read.getCronical_Desease());

        System.out.println("In read, read = " + read.getCronical_Desease());
    }
    @Test
    public void update()  {
        MedicalHistory medicalHistory = new MedicalHistory.Builder()
                .medHistory_ID(values.get("MedHistory_ID"))
                .cronical_Desease("Aids")
                .build();
        repository.update(medicalHistory);
        MedicalHistory updated = repository.read("7676");
        assertEquals("Aids",updated.getCronical_Desease());
    }


    @Test
    public void delete() {
        this.repository.delete("55555");
        MedicalHistory medicalHistory= repository.read("55555");
        assertNull(medicalHistory);
    }

    @Test
    public void  getAll(){
        Map<String,MedicalHistory> all = this.repository.getAll();
        System.out.println(all);
    }



}