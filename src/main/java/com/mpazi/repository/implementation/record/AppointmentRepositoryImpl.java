package com.mpazi.repository.implementation.record;

import com.mpazi.domain.patient.record.Appointment;
import com.mpazi.repository.record.AppointmentRepository;

import java.util.HashSet;
import java.util.Set;


public class AppointmentRepositoryImpl implements AppointmentRepository {

    private  static  AppointmentRepositoryImpl repository = null;
    private Set<Appointment> appointments;

    private AppointmentRepositoryImpl(){
        this.appointments = new HashSet<>();
    }

    public static AppointmentRepositoryImpl getRepository(){
        if(repository == null)
            repository = new AppointmentRepositoryImpl();
        return repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        this.appointments.add(appointment);
        return appointment;
    }

    @Override
    public Appointment update(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment read(String s) {

        return null;
    }

    @Override
    public void delete(String appointment_ID) {
        this.appointments.remove(appointment_ID);
    }
}
