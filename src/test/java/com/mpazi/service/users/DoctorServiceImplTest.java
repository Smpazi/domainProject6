package com.mpazi.service.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.factory.users.factory.DoctorFactory;
import com.mpazi.repository.users.DoctorRepository;
import com.mpazi.repository.users.impl.DoctorRepositoryImpl;
import com.mpazi.service.users.impl.DoctorServiceImpl;
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
public class DoctorServiceImplTest {

    Map<String, String> values;
    private DoctorService service;
    private Doctor doctor;

    @Before
    public void setUp() throws Exception {
        this.service = DoctorServiceImpl.getInstance();
        values = new HashMap<>();

        this.doctor = DoctorFactory.getDoctor("34444");

    }

    @Test
    public void create() {
        Doctor created = this.service.create(doctor);
        System.out.println("In create, created = " + created);
        service.create(created);
        Assert.assertSame(created, this.doctor);

    }
    @Test
    public void read() {
        Doctor appoint = new Doctor.Builder()
                .doc_practiceNum("34444")
                .build();
        service.create(appoint);
        Doctor read = service.read("34444");
        System.out.println("In read, read = " +read.getDoc_practiceNum() );
    }
    @Test
    public void update()  {
        Doctor doctor = new Doctor.Builder()
                .doc_practiceNum("34444")
                .build();
        service.update(doctor);
        Doctor updated = service.read("34444");
        assertEquals("34444",updated.getDoc_practiceNum());
    }


    @Test
    public void delete() {
        this.service.delete("34444");
        Doctor doctor= service.read("34444");
        assertNull(doctor);
    }

    @Test
    public void  getAll(){
        Map<String, Doctor> all = this.service.getAll();
        System.out.println(all);
    }

}