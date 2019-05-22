package com.mpazi.service.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.service.IService;

import java.util.Map;

public interface AppointmentService extends IService<Appointment, String> {
    Map<String, Appointment> getAll();
}
