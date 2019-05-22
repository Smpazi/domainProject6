package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.Consultation;
import com.mpazi.repository.information.ConsultationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryConsultation")

public class ConsultationRepositoryImpl implements ConsultationRepository {

    private  static  ConsultationRepositoryImpl repository = null;
    private Map<String,Consultation> consultationList;

    private ConsultationRepositoryImpl(){
         this.consultationList = new HashMap<>();
    }

    public static ConsultationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ConsultationRepositoryImpl();
        return repository;
    }

    @Override
    public Consultation create(Consultation consultation) {
        consultationList.put(consultation.getConsult_description(),consultation);
        Consultation savedConsalt = consultationList.get(consultation.getConsult_description());
        return savedConsalt;
    }

    @Override
    public Consultation update(Consultation consultation) {
        consultationList.put(consultation.getConsult_description(),consultation);
        Consultation savedConsalt = consultationList.get(consultation.getConsult_description());
        return savedConsalt;
    }

    @Override
    public Consultation read(String s) {
        Consultation consultation = consultationList.get(s);
        return consultation ;
    }

    @Override
    public void delete(String consultation_ID) {
        this.consultationList.remove(consultation_ID);
    }

    @Override
    public Map<String, Consultation> getAll() {
        return this.consultationList;
    }
}
