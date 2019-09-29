package com.mpazi.service.information.impl;

import com.mpazi.domain.information.Appointment;
import com.mpazi.repository.information.AppointmentRepository;
import com.mpazi.repository.information.impl.AppointmentRepositoryImpl;
import com.mpazi.service.information.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service ("ServiceImpAppointment")
public class AppointmentServiceImpl implements AppointmentService {

    @Qualifier("InMemoryAppointment")
    private  static AppointmentServiceImpl service = null;

    AppointmentRepository repository = AppointmentRepositoryImpl.getRepository();

    public static AppointmentServiceImpl getInstance(){
        if(service == null)
            service =new AppointmentServiceImpl();
        return service;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return repository.create(appointment);
    }

    @Override
    public Appointment update(Appointment appointment) {
        return repository.update(appointment);
    }

    @Override
    public void delete(String id) {

        repository.delete(id);
    }

    @Override
    public Appointment read(String id) {
        return repository.read(id);
    }

    @Override
    public Map<String, Appointment> getAll() {
        return repository.getAll();
    }
}
