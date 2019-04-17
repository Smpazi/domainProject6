package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.CheckUpPatient;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckUpPatientFactoryTest {

    @Test
    public void getCheckUpPatientTest(){

        CheckUpPatient check = CheckUpPatientFactory.getCheckUpPatient("wound clean up");

        assertEquals("wound clean up",check.getCheckUpName());
    }

}