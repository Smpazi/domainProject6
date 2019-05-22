package com.mpazi.service.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.factory.information.factory.ConsultationFactory;
import com.mpazi.repository.information.ConsultationRepository;
import com.mpazi.repository.information.impl.ConsultationRepositoryImpl;
import com.mpazi.service.information.impl.ConsultationServiceImpl;
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

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultationServiceImplTest {
    Map<String, String> values;
    private ConsultationService service;
    private Consultation consultation;

    @Before
    public void setUp() throws Exception {
        this.service = ConsultationServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Consultation_Description","illness");


        this.consultation = ConsultationFactory.getConsultation(values);

    }

    @Test
    public void create() {
        Consultation created = this.service.create(consultation);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.consultation);

    }
    @Test
    public void read() {
        Consultation consultation = new Consultation.Builder()
                .consult_description(values.get("Consultation_Description"))
                .build();
        service.create(consultation);
        Consultation read = service.read("illness");
        System.out.println("In read, read = " + read.getConsult_description());
    }
    @Test
    public void update()  {
        Consultation consultation = new Consultation.Builder()
                .consult_description("Fever")
                .build();
        service.update(consultation);
        Consultation update = service.read("Fever");
        assertEquals("Fever",update.getConsult_description());
    }


    @Test
    public void delete() {
        this.service.delete("illness");
        Consultation consultation= service.read("illness");
        assertNull(consultation);

    }

    @Test
    public void  getAll(){
        Map<String,Consultation> all = this.service.getAll();
        System.out.println(all);
    }


}