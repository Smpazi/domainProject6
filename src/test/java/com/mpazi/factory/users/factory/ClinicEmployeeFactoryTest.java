package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClinicEmployeeFactoryTest {
    @Test
    public void getClinicEmployeeTest(){

        ClinicEmployee clinicEmployee =ClinicEmployeeFactory.getClinicEmployee();

        //assertEquals();

    }

}