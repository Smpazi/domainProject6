package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.Consultation;
import com.mpazi.repository.information.ConsultationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ConsultationRepositoryImpl implements ConsultationRepository {

    private  static  ConsultationRepositoryImpl repository = null;
    private List<Consultation> consultationList;

    private ConsultationRepositoryImpl(){
         this.consultationList = new ArrayList<>();
    }

    public static ConsultationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ConsultationRepositoryImpl();
        return repository;
    }

    @Override
    public Consultation create(Consultation consultation) {
        this.consultationList.add(consultation);
        return consultation;
    }

    @Override
    public Consultation update(Consultation consultation) {
        return null;
    }

    @Override
    public Consultation read(String s) {
        return null;
    }

    @Override
    public void delete(String consultation_ID) {

        this.consultationList.remove(consultation_ID);
    }

    @Override
    public Set<Consultation> getAll() {
        return null;
    }
}
