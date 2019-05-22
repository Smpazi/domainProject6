package com.mpazi.repository.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.factory.login.factory.RegistrationFactory;
import com.mpazi.repository.login.impl.RegistrationRepositoryImpl;
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
public class RegistrationRepositoryTest {
    Map<String, String> values;
    private RegistrationRepository repository;
    private Registration registration;

    @Before
    public void setUp() throws Exception {
        this.repository = RegistrationRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Reg_ID","AS322");
        values.put("StaffName","Dr. LEXIS");
        this.registration = RegistrationFactory.getRegistration(values);

    }

    @Test
    public void create() {
        Registration created = this.repository.create(registration);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.registration);

    }
    @Test
    public void read() {
        Registration appoint = new Registration.Builder()
                .reg_Id(values.get("Reg_ID"))
                .staffName(values.get("StaffName"))
                .build();
        repository.create(appoint);
        Registration read = repository.read("AS322");
        assertEquals("Dr. LEXIS",read.getStaffName());

        System.out.println("In read, read = " +read.getStaffName());
    }
    @Test
    public void update()  {
        Registration newAppointment = new Registration.Builder()
                .reg_Id(values.get("Reg_ID"))
                .staffName("Dr Sloan")
                .build();
        repository.update(newAppointment);
        Registration updated = repository.read("AS322");
        assertEquals("Dr Sloan",updated.getStaffName());
    }


    @Test
    public void delete() {

        this.repository.delete("AS322");
        Registration registration= repository.read("AS322");
        assertNull(registration);

    }

    @Test
    public void  getAll(){
        Map<String,Registration> all = this.repository.getAll();
        System.out.println(all);
    }


}