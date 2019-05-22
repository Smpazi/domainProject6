package com.mpazi.service.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.factory.information.factory.MedicalHistoryFactory;
import com.mpazi.repository.information.MedicalHistoryRepository;
import com.mpazi.repository.information.impl.MedicalHistoryRepositoryImpl;
import com.mpazi.service.information.impl.MedicalHistoryServiceImpl;
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
public class MedicalHistoryServiceImplTest {
    Map<String, String> values;
    private MedicalHistoryService  service;
    private MedicalHistory medicalHistory;

    @Before
    public void setUp() throws Exception {
        this.service = MedicalHistoryServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("MedHistory_ID","7676");
        values.put("Cronical_Desease","Cancer");


        this.medicalHistory = MedicalHistoryFactory.getMedicalHistory(values);

    }

    @Test
    public void create() {
        MedicalHistory created = this.service.create(medicalHistory);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.medicalHistory);

    }
    @Test
    public void read() {
        MedicalHistory medicalHistory = new MedicalHistory.Builder()
                .medHistory_ID(values.get("MedHistory_ID"))
                .cronical_Desease(values.get("Cronical_Desease"))
                .build();
        service.create(medicalHistory);
        MedicalHistory read = service.read("7676");
        System.out.println("In read, read = " + read.getCronical_Desease());
    }
    @Test
    public void update()  {
        MedicalHistory medicalHistory = new MedicalHistory.Builder()
                .medHistory_ID(values.get("MedHistory_ID"))
                .cronical_Desease("Aids")
                .build();
        service.update(medicalHistory);
        MedicalHistory updated = service.read("7676");
        assertEquals("Aids",updated.getCronical_Desease());
    }


    @Test
    public void delete() {
        this.service.delete("55555");
        MedicalHistory medicalHistory= service.read("55555");
        assertNull(medicalHistory);
    }

    @Test
    public void  getAll(){
        Map<String,MedicalHistory> all = this.service.getAll();
        System.out.println(all);
    }



}