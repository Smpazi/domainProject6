package com.mpazi.factory.login.factory;

import com.mpazi.domain.register.login.Registration;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationFactoryTest {

    @Test
    public void getRegistrationTest(){

        Registration reg = RegistrationFactory.getRegistration("Derek");

        assertEquals("Derek",reg.getStaffName());
    }

}