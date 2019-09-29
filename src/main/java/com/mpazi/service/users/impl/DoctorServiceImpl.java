package com.mpazi.service.users.impl;

import com.mpazi.domain.users.Doctor;
import com.mpazi.repository.users.DoctorRepository;
import com.mpazi.repository.users.impl.DoctorRepositoryImpl;
import com.mpazi.service.users.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpDoctor")
public class DoctorServiceImpl implements DoctorService {
    @Qualifier("InMemoryDoctor")
    private  static DoctorServiceImpl service = null;

    DoctorRepository repository = DoctorRepositoryImpl.getRepository();

    public static DoctorServiceImpl getInstance(){
        if(service == null)
            service =new DoctorServiceImpl();
        return service;
    }
    @Override
    public Doctor create(Doctor doctor) {
        return repository.create(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return repository.update(doctor);
    }

    @Override
    public void delete(String s) {
repository.delete(s);
    }

    @Override
    public Doctor read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Doctor> getAll() {
        return repository.getAll();
    }
}
