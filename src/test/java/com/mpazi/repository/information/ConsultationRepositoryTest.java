package com.mpazi.repository.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.factory.information.factory.ConsultationFactory;
import com.mpazi.repository.information.impl.ConsultationRepositoryImpl;
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
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ConsultationRepositoryTest {

    Map<String, String> values;
    private ConsultationRepository repository;
    private Consultation consultation;

    @Before
    public void setUp() throws Exception {
        this.repository = ConsultationRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Consultation_Description","illness");


        this.consultation = ConsultationFactory.getConsultation(values);

    }

    @Test
    public void create() {
        Consultation created = this.repository.create(consultation);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.consultation);

    }
    @Test
    public void read() {
        Consultation consultation = new Consultation.Builder()
                .consult_description(values.get("Consultation_Description"))
                .build();
        repository.create(consultation);
        Consultation read = repository.read("illness");
        assertEquals("illness",read.getConsult_description());

        System.out.println("In read, read = " + read.getConsult_description());
    }
    @Test
    public void update()  {
        Consultation consultation = new Consultation.Builder()
                .consult_description("Fever")
                .build();
        repository.update(consultation);
        Consultation update = repository.read("Fever");
        assertEquals("Fever",update.getConsult_description());
    }


    @Test
    public void delete() {
        this.repository.delete("illness");
        Consultation consultation= repository.read("illness");
        assertNull(consultation);

    }

    @Test
    public void  getAll(){
        Map<String,Consultation> all = this.repository.getAll();
        System.out.println(all);
    }




}