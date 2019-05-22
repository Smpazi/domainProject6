package com.mpazi.service.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.factory.users.factory.ReceptionistFactory;
import com.mpazi.repository.users.ReceptionistRepository;
import com.mpazi.repository.users.impl.ReceptionistRepositoryImpl;
import com.mpazi.service.users.impl.ReceptionistServiceImpl;
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
public class ReceptionistServiceImplTest {
    Map<String, String> values;
    private ReceptionistService service;
    private Receptionist receptionist;

    @Before
    public void setUp() throws Exception {
        this.service = ReceptionistServiceImpl.getInstance();
        values = new HashMap<>();


        this.receptionist = ReceptionistFactory.getReceptionist("Admin");

    }

    @Test
    public void create() {
        Receptionist created = this.service.create(receptionist);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.receptionist);

    }
    @Test
    public void read() {
        Receptionist appoint = new Receptionist.Builder()
                .job_type("Admin")
                .build();
        service.create(appoint);
        Receptionist read = service.read("Admin");
        assertEquals("Admin",read.getJob_type());

        System.out.println("In read, read = " +read.getJob_type() );
    }
    @Test
    public void update()  {
        Receptionist receptionist = new Receptionist.Builder()
                .job_type("Admin")
                .build();
        service.update(receptionist);
        Receptionist updated = service.read("Admin");
        assertEquals("Admin",updated.getJob_type());
    }


    @Test
    public void delete() {

        this.service.delete("AS322");
        Receptionist receptionist= service.read("AS322");
        assertNull(receptionist);

    }

    @Test
    public void  getAll(){
        Map<String, Receptionist> all = this.service.getAll();
        System.out.println(all);
    }
}