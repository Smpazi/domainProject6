package com.mpazi.repository.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.factory.template.factory.RecordTempleteFactory;
import com.mpazi.repository.template.impl.RecordTempleteRepositoryImpl;
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
public class RecordTempleteRepositoryTest {
    Map<String, String> values;
    private RecordTempleteRepository repository;
    private RecordTemplete recordTemplete;

    @Before
    public void setUp() throws Exception {
        this.repository = RecordTempleteRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Template_ID","ac33");

        this.recordTemplete = RecordTempleteFactory.getRecordTemplete(values,7);

    }

    @Test
    public void create() {
        RecordTemplete created = this.repository.create(recordTemplete);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.recordTemplete);

    }
    @Test
    public void read() {
        RecordTemplete appoint = new RecordTemplete.Builder()
                .templeteId(values.get("Template_ID"))
                .timeVisit(7)
                .build();
        repository.create(appoint);
        RecordTemplete read = repository.read("ac33");
        assertEquals(7,read.getTimeVisit());

        System.out.println("In read, read = " +read.getTimeVisit() );
    }
    @Test
    public void update()  {
        RecordTemplete newAppointment = new RecordTemplete.Builder()
                .templeteId(values.get("Template_ID"))
                .timeVisit(8)
                .build();
        repository.update(newAppointment);
        RecordTemplete updated = repository.read("ac33");
        assertEquals(8,updated.getTimeVisit());
    }


    @Test
    public void delete() {

        this.repository.delete("ac33");
        RecordTemplete notification= repository.read("ac33");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String, RecordTemplete> all = this.repository.getAll();
        System.out.println(all);
    }

}