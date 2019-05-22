package com.mpazi.service.information.impl;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.repository.information.PatientNoteRepository;
import com.mpazi.repository.information.impl.PatientNoteRepositoryImpl;
import com.mpazi.service.information.PatientNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpPatientNote")
public class PatientNoteServiceImpl implements PatientNoteService {

    @Autowired
    @Qualifier("InMemoryPatientNote")
    private  static PatientNoteServiceImpl service = null;

    PatientNoteRepository repository = PatientNoteRepositoryImpl.getRepository();

    public static PatientNoteServiceImpl getInstance(){
        if(service == null)
            service =new PatientNoteServiceImpl();
        return service;
    }
    @Override
    public PatientNote create(PatientNote patientNote) {
        return repository.create(patientNote);
    }

    @Override
    public PatientNote update(PatientNote patientNote) {
        return repository.update(patientNote);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public PatientNote read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, PatientNote> getAll() {
        return repository.getAll();
    }
}