package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class RoleFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("RoleTitle","DoctorController");

    }
    @Test
    public void getRoleTest() {

        Role role= RoleFactory.getRoleFactory(values);

        Assert.assertEquals("DoctorController",role.getRoleTitle());

    }
}