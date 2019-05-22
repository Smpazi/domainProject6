package com.mpazi.repository.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface AppointmentRepository extends IRepository<Appointment, String> {
    Map<String, Appointment> getAll();
}
