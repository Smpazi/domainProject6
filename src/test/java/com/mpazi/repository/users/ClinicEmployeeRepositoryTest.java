package com.mpazi.repository.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.factory.users.factory.ClinicEmployeeFactory;
import com.mpazi.repository.users.impl.ClinicEmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class ClinicEmployeeRepositoryTest {

    Map<String, String> values;
    private ClinicEmployeeRepository repository;
    private ClinicEmployee clinicEmployee;

    @Before
    public void setUp() throws Exception {
        this.repository = ClinicEmployeeRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("Employee_ID","23");

        this.clinicEmployee = ClinicEmployeeFactory.getClinicEmployee(values,7777);

    }

    @Test
    public void create() {
        ClinicEmployee created = this.repository.create(clinicEmployee);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.clinicEmployee);

    }
    @Test
    public void read() {
        ClinicEmployee appoint = new ClinicEmployee.Builder()
                .emp_Id(values.get("Employee_ID"))
                .empPhoneNum(7777)
                .build();
        repository.create(appoint);
        ClinicEmployee read = repository.read("23");
        assertEquals(7777,read.getEmpPhoneNum());

        System.out.println("In read, read = " +read.getEmpPhoneNum() );
    }
    @Test
    public void update()  {
        ClinicEmployee newAppointment = new ClinicEmployee.Builder()
                .emp_Id(values.get("Employee_ID"))
                .empPhoneNum(044444)
                .build();
        repository.update(newAppointment);
        ClinicEmployee updated = repository.read("23");
        assertEquals(044444,updated.getEmpPhoneNum());
    }


    @Test
    public void delete() {

        this.repository.delete("23");
        ClinicEmployee notification= repository.read("23");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String,ClinicEmployee> all = this.repository.getAll();
        System.out.println(all);
    }

}