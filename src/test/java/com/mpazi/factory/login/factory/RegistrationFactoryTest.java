package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Registration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RegistrationFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("StaffName","lomie");

    }
    @Test
    public void getRegistrationTest() {

        Registration registration = RegistrationFactory.getRegistration(values);

        Assert.assertEquals("lomie",registration.getStaffName());

    }
}