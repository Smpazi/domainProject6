package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpPatient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CheckUpPatientFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("CheckUp_Reason","Wound dressing");
        values.put("CheckUp_Date","23/April/2011");

    }
    @Test
    public void getCheckUpPatientTest() {

        CheckUpPatient checkUpPatient = CheckUpPatientFactory.getCheckUpPatient(values);

        Assert.assertEquals("Wound dressing",checkUpPatient.getCheckUp_Reason());

    }
}