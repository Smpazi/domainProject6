package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.Appointment;
import com.mpazi.util.Misc;

public class AppointmentFactory {

    public static Appointment getAppointment(String appoName){
       return new Appointment.Builder().appointmentId(Misc.generateId())
                .appointmentName(appoName)
                .build();
    }
}
