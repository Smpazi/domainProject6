package com.mpazi.repository.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.factory.users.factory.ClinicEmployeeFactory;
import com.mpazi.repository.implementation.users.ClinicEmployeeRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ClinicEmployeeRepositoryTest {

    Set<ClinicEmployee> clinicEmployees;
    ClinicEmployeeRepository repository;

    ClinicEmployee clinicEmployee;
    @Before
    public void setUp() throws Exception {
        repository = ClinicEmployeeRepositoryImpl.getRepository();
        clinicEmployees = new HashSet<>();
        clinicEmployees.add(clinicEmployee);
    }

    @Test
    public void create() throws Exception{
        clinicEmployee= ClinicEmployeeFactory.getClinicEmployee("W444",0621423);
        repository.create(clinicEmployee);
        assertEquals(0621423, clinicEmployee.getEmpPhoneNum());
    }

    @Test
    public void read() throws Exception {
        clinicEmployee = repository.read("2222");
        assertEquals("2222",clinicEmployee.getEmp_Id());
    }

    @Test
    public void update() throws Exception{
        clinicEmployee = repository.read("2222");
        ClinicEmployee newEmployee = new ClinicEmployee.Builder()
                .emp_Id("2222")
                .empPhoneNum(0723456)
                .build();
        repository.update(newEmployee);
        ClinicEmployee updateEmplyee = repository.read("2222");
        assertEquals(0723456,updateEmplyee.getEmpPhoneNum());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("2222");
        clinicEmployees.remove("2222");
        clinicEmployee= repository.read("2222");
        assertNull(clinicEmployees);
    }



}