package com.mpazi.repository.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface AppointmentRepository extends IRepository<Appointment, String> {
    Set<Appointment> getAll();
}
