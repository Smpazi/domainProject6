package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Appointment;
import com.mpazi.util.Misc;

import java.util.Map;

public class AppointmentFactory {

    public static Appointment getAppointment(Map<String, String> values){
       return new Appointment.Builder()
                .appointmentId(values.get("AppointmentId"))
               .appointmentDate(values.get("AppointmentDate"))
                .appointmentName(values.get("AppointmentName"))
                .build();
    }
}
