package com.mpazi.service.information.impl;

import com.mpazi.domain.information.Patient;
import com.mpazi.repository.information.PatientRepository;
import com.mpazi.repository.information.impl.PatientRepositoryImpl;
import com.mpazi.service.information.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpPatient")
public  class PatientServiceImpl implements PatientService {

    @Qualifier("InMemoryPatient")
    private  static PatientServiceImpl service = null;

    PatientRepository repository = PatientRepositoryImpl.getRepository();

    public static PatientServiceImpl getInstance(){
        if(service == null)
            service =new PatientServiceImpl();
        return service;
    }
    @Override
    public Patient create(Patient patient) {
        return repository.create(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return repository.update(patient);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Patient read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Patient> getAll() {
        return repository.getAll();
    }
}
