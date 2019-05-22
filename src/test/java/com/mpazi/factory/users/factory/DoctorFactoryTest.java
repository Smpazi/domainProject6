package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Doctor;
import com.mpazi.factory.users.factory.DoctorFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorFactoryTest {
    @Test
    public void getDoctorTest(){

        Doctor doctor = DoctorFactory.getDoctor("D5555");

        assertNotNull(doctor.getDoc_practiceNum());

    }
}