package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicEmployeeFactoryTest {
    @Test
    public void getClinicEmployeeTest(){

        ClinicEmployee clinicEmployee =ClinicEmployeeFactory.getClinicEmployee("",045667);

        assertEquals(045667,clinicEmployee.getEmpPhoneNum());

    }

}