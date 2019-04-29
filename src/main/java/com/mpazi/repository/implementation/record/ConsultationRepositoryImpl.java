package com.mpazi.repository.implementation.record;

import com.mpazi.domain.patient.record.Consultation;
import com.mpazi.repository.record.ConsultationRepository;

import java.util.ArrayList;
import java.util.List;

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
}
