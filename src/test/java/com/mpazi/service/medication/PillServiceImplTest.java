package com.mpazi.service.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.factory.medication.factory.PillFactory;
import com.mpazi.repository.medication.PillRepository;
import com.mpazi.repository.medication.impl.PillRepositoryImpl;
import com.mpazi.service.medication.impl.PillServiceImpl;
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
public class PillServiceImplTest {

    Map<String, String> values;
    private PillService service;
    private Pill pill;

    @Before
    public void setUp() throws Exception {
        this.service = PillServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("pill_ID","889");

        this.pill = PillFactory.getPill(values,33);

    }

    @Test
    public void create() {
        Pill created = this.service.create(pill);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.pill);

    }
    @Test
    public void read() {
        Pill appoint = new Pill.Builder()
                .pill_ID("pill_ID")
                .pillQuantity(33)
                .build();
        service.create(appoint);
        Pill read = service.read("889");
        assertEquals(33,read.getPillQuantity());

        System.out.println("In read, read = " +read.getPillQuantity() );
    }
    @Test
    public void update()  {
        Pill pill = new Pill.Builder()
                .pill_ID("pill_ID")
                .pillQuantity(666)
                .build();
        service.update(pill);
        Pill updated = service.read("889");
        assertEquals(666,updated.getPillQuantity());
    }


    @Test
    public void delete() {

        this.service.delete("889");
        Pill pill= service.read("889");
        assertNull(pill);

    }

    @Test
    public void  getAll(){
        Map<String, Pill> all = this.service.getAll();
        System.out.println(all);
    }

}