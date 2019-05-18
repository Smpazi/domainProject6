package com.mpazi.service.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.service.IService;

import java.util.Set;

public interface AppointmentService extends IService<Appointment, String> {
    Set<Appointment> getAll();
}
