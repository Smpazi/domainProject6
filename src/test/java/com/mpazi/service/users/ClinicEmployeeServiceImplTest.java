package com.mpazi.service.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.factory.users.factory.ClinicEmployeeFactory;
import com.mpazi.repository.users.ClinicEmployeeRepository;
import com.mpazi.repository.users.impl.ClinicEmployeeRepositoryImpl;
import com.mpazi.service.users.impl.ClinicEmployeeServiceImpl;
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
public class ClinicEmployeeServiceImplTest {

    Map<String, String> values;
    private ClinicEmployeeService service;
    private ClinicEmployee clinicEmployee;

    @Before
    public void setUp() throws Exception {
        this.service = ClinicEmployeeServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("Employee_ID","23");

        this.clinicEmployee = ClinicEmployeeFactory.getClinicEmployee(values,7777);

    }

    @Test
    public void create() {
        ClinicEmployee created = this.service.create(clinicEmployee);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.clinicEmployee);

    }
    @Test
    public void read() {
        ClinicEmployee appoint = new ClinicEmployee.Builder()
                .emp_Id(values.get("Employee_ID"))
                .empPhoneNum(7777)
                .build();
        service.create(appoint);
        ClinicEmployee read = service.read("23");
        assertEquals(7777,read.getEmpPhoneNum());

        System.out.println("In read, read = " +read.getEmpPhoneNum() );
    }
    @Test
    public void update()  {
        ClinicEmployee newAppointment = new ClinicEmployee.Builder()
                .emp_Id(values.get("Employee_ID"))
                .empPhoneNum(044444)
                .build();
        service.update(newAppointment);
        ClinicEmployee updated = service.read("23");
        assertEquals(044444,updated.getEmpPhoneNum());
    }


    @Test
    public void delete() {

        this.service.delete("23");
        ClinicEmployee employee= service.read("23");
        assertNull(employee);

    }

    @Test
    public void  getAll(){
        Map<String,ClinicEmployee> all = this.service.getAll();
        System.out.println(all);
    }

}