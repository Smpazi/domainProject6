package com.mpazi.repository.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.factory.users.factory.ReceptionistFactory;
import com.mpazi.repository.users.impl.ReceptionistRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ReceptionistRepositoryTest {
    Map<String, String> values;
    private ReceptionistRepository repository;
    private Receptionist receptionist;

    @Before
    public void setUp() throws Exception {
        this.repository = ReceptionistRepositoryImpl.getRepository();
        values = new HashMap<>();

        this.receptionist = ReceptionistFactory.getReceptionist("Admin");

    }

    @Test
    public void create() {
        Receptionist created = this.repository.create(receptionist);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.receptionist);

    }
    @Test
    public void read() {
        Receptionist appoint = new Receptionist.Builder()
                .job_type("Admin")
                .build();
        repository.create(appoint);
        Receptionist read = repository.read("Admin");
        assertEquals("Admin",read.getJob_type());

        System.out.println("In read, read = " +read.getJob_type() );
    }
    @Test
    public void update()  {
        Receptionist receptionist = new Receptionist.Builder()
                .job_type("Admin")
                .build();
        repository.update(receptionist);
        Receptionist updated = repository.read("Admin");
        assertEquals("Admin",updated.getJob_type());
    }

    @Test
    public void delete() {

        this.repository.delete("Admin");
        Receptionist receptionist= repository.read("Admin");
        assertNull(receptionist);
    }

    @Test
    public void  getAll(){
        Map<String, Receptionist> all = this.repository.getAll();
        System.out.println(all);
    }

}