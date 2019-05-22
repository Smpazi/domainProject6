package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Appointment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class AppointmentFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("AppointmentDate","10/May/2010");

    }
    @Test
    public void getAppointmentTest() {

        Appointment appointment= AppointmentFactory.getAppointment(values);

        Assert.assertEquals("10/May/2010",appointment.getAppointmentDate());

    }


}