package com.mpazi.repository.template.impl;

import com.mpazi.domain.template.Treatment;
import com.mpazi.repository.template.TreatmentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryTreatment")

public class TreatmentRepositoryImpl implements TreatmentRepository {

    private  static  TreatmentRepositoryImpl repository = null;
    private Map<String, Treatment> treatmentTable;

    private TreatmentRepositoryImpl(){
        treatmentTable = new HashMap<>();
    }

    public static TreatmentRepositoryImpl getRepository(){
        if(repository == null)
            repository = new TreatmentRepositoryImpl();
        return repository;
    }

    @Override
    public Treatment create(Treatment treatment) {
        treatmentTable.put(treatment.getTreatment_ID(),treatment);
        Treatment saveTreatment = treatmentTable.get(treatment.getTreatment_ID());
        return saveTreatment;
    }

    @Override
    public Treatment update(Treatment treatment) {
        treatmentTable.put(treatment.getTreatment_ID(),treatment);
        Treatment updateTreatment = treatmentTable.get(treatment.getTreatment_ID());

        return updateTreatment;
    }

    @Override
    public void delete(String treatment_ID) {

        treatmentTable.remove(treatment_ID);
    }

    @Override
    public Treatment read(String treatment_ID) {
        Treatment treatment = treatmentTable.get(treatment_ID);
        return treatment;
    }

    @Override
    public Map<String, Treatment> getAll() {
        return treatmentTable;
    }
}
