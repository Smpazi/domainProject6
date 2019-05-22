package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.Appointment;
import com.mpazi.repository.information.AppointmentRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("InMemoryAppointment")
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private  static  AppointmentRepositoryImpl repository = null;
    private Map<String, Appointment> appointments;

    private AppointmentRepositoryImpl(){
        this.appointments =new HashMap<>();
    }

    public static AppointmentRepositoryImpl getRepository(){
        if(repository == null)
            repository = new AppointmentRepositoryImpl();
        return repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        appointments.put(appointment.getAppointmentId(),appointment);
        Appointment savedAppoinment = appointments.get(appointment.getAppointmentId());
        return savedAppoinment;
    }

    @Override
    public Appointment update(Appointment appointment) {
        appointments.put(appointment.getAppointmentId(),appointment);
        return this.appointments.get(appointment.getAppointmentId());
    }

    @Override
    public Appointment read(String id) {
        Appointment appointment = appointments.get(id);
        return appointment;
    }

    @Override
    public void delete(String appointment_ID) {
        this.appointments.remove(appointment_ID);
    }

    @Override
    public Map<String, Appointment> getAll() {

        return this.appointments;
    }
}
