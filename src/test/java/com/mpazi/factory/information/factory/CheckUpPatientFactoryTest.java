package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpPatient;
import org.junit.Test;

public class CheckUpPatientFactoryTest {

    @Test
    public void getCheckUpPatientTest(){

        CheckUpPatient check = CheckUpPatientFactory.getCheckUpPatient("wound clean up");

        assertEquals("wound clean up",check.getCheckUpName());
    }

}