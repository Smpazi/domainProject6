package com.mpazi.repository.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.factory.users.factory.DoctorFactory;
import com.mpazi.repository.users.impl.DoctorRepositoryImpl;
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
public class DoctorRepositoryTest {
    Map<String, String> values;
    private DoctorRepository repository;
    private Doctor doctor;

    @Before
    public void setUp() throws Exception {
        this.repository = DoctorRepositoryImpl.getRepository();
        values = new HashMap<>();

      this.doctor = DoctorFactory.getDoctor("34444");

    }

    @Test
    public void create() {
        Doctor created = this.repository.create(doctor);
        System.out.println("In create, created = " + created);
        repository.create(created);
        Assert.assertSame(created, this.doctor);

    }
    @Test
    public void read() {
        Doctor appoint = new Doctor.Builder()
                .doc_practiceNum("34444")
                .build();
        repository.create(appoint);
        Doctor read = repository.read("34444");
        System.out.println("In read, read = " +read.getDoc_practiceNum() );
    }
    @Test
    public void update()  {
        Doctor doctor = new Doctor.Builder()
                .doc_practiceNum("34444")
                .build();
        repository.update(doctor);
        Doctor updated = repository.read("34444");
        assertEquals("34444",updated.getDoc_practiceNum());
    }


    @Test
    public void delete() {
        this.repository.delete("34444");
        Doctor doctor= repository.read("34444");
        assertNull(doctor);
    }

    @Test
    public void  getAll(){
        Map<String, Doctor> all = this.repository.getAll();
        System.out.println(all);
    }

}