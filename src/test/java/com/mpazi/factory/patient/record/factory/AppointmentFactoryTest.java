package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.Appointment;
import org.junit.Assert;
import org.junit.Test;

public class AppointmentFactoryTest {

    @Test
    public void getAppointmentTest() {

        Appointment appointment= AppointmentFactory.getAppointment("ClinicVisit");

        Assert.assertEquals("ClinicVisit",appointment.getAppointmentName());

    }

}