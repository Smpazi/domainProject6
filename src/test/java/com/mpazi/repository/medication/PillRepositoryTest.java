package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.factory.medication.factory.PillFactory;
import com.mpazi.repository.medication.impl.PillRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PillRepositoryTest {
    Map<String, String> values;
    private PillRepository repository;
    private Pill pill;

    @Before
    public void setUp() throws Exception {
        this.repository = PillRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("pill_ID","889");

        this.pill = PillFactory.getPill(values,33);

    }

    @Test
    public void create() {
        Pill created = this.repository.create(pill);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.pill);

    }
    @Test
    public void read() {
        Pill appoint = new Pill.Builder()
                .pill_ID("pill_ID")
                .pillQuantity(33)
                .build();
        repository.create(appoint);
        Pill read = repository.read("889");
        assertEquals(33,read.getPillQuantity());

        System.out.println("In read, read = " +read.getPillQuantity() );
    }
    @Test
    public void update()  {
        Pill pill = new Pill.Builder()
                .pill_ID("pill_ID")
                .pillQuantity(666)
                .build();
        repository.update(pill);
        Pill updated = repository.read("889");
        assertEquals(666,updated.getPillQuantity());
    }


    @Test
    public void delete() {

        this.repository.delete("889");
        Pill pill= repository.read("889");
        assertNull(pill);

    }

    @Test
    public void  getAll(){
        Map<String, Pill> all = this.repository.getAll();
        System.out.println(all);
    }

}