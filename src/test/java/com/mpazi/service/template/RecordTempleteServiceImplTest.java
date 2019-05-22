package com.mpazi.service.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.factory.template.factory.RecordTempleteFactory;
import com.mpazi.repository.template.RecordTempleteRepository;
import com.mpazi.repository.template.impl.RecordTempleteRepositoryImpl;
import com.mpazi.service.template.impl.RecordTempleteServiceImpl;
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
public class RecordTempleteServiceImplTest {

    Map<String, String> values;
    private RecordTempleteService service;
    private RecordTemplete recordTemplete;

    @Before
    public void setUp() throws Exception {
        this.service = RecordTempleteServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Template_ID","ac33");

        this.recordTemplete = RecordTempleteFactory.getRecordTemplete(values,7);

    }

    @Test
    public void create() {
        RecordTemplete created = this.service.create(recordTemplete);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.recordTemplete);

    }
    @Test
    public void read() {
        RecordTemplete appoint = new RecordTemplete.Builder()
                .templeteId(values.get("Template_ID"))
                .timeVisit(7)
                .build();
        service.create(appoint);
        RecordTemplete read = service.read("ac33");
        assertEquals(7,read.getTimeVisit());

        System.out.println("In read, read = " +read.getTimeVisit() );
    }
    @Test
    public void update()  {
        RecordTemplete newAppointment = new RecordTemplete.Builder()
                .templeteId(values.get("Template_ID"))
                .timeVisit(8)
                .build();
        service.update(newAppointment);
        RecordTemplete updated = service.read("ac33");
        assertEquals(8,updated.getTimeVisit());
    }


    @Test
    public void delete() {

        this.service.delete("ac33");
        RecordTemplete notification= service.read("ac33");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String, RecordTemplete> all = this.service.getAll();
        System.out.println(all);
    }

}