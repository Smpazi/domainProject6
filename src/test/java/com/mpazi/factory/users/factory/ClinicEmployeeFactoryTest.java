package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ClinicEmployeeFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();

    }
    @Test
    public void getAppointmentTest() {

        ClinicEmployee clinicEmployee=  ClinicEmployeeFactory.getClinicEmployee(values,062153);

        Assert.assertEquals(062153,clinicEmployee.getEmpPhoneNum());

    }
}