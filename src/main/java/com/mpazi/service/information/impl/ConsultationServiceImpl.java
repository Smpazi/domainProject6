package com.mpazi.service.information.impl;

import com.mpazi.domain.information.Consultation;
import com.mpazi.repository.information.ConsultationRepository;
import com.mpazi.repository.information.impl.ConsultationRepositoryImpl;
import com.mpazi.service.information.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpConsultation")
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    @Qualifier("InMemoryConsultation")
    private  static ConsultationServiceImpl service = null;

    ConsultationRepository repository = ConsultationRepositoryImpl.getRepository();

    public static ConsultationServiceImpl getInstance(){
        if(service == null)
            service =new ConsultationServiceImpl();
        return service;
    }

    @Override
    public Consultation create(Consultation consultation) {
        return repository.create(consultation);
    }

    @Override
    public Consultation update(Consultation consultation) {
        return repository.update(consultation);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Consultation read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Consultation> getAll() {
        return repository.getAll();
    }
}
