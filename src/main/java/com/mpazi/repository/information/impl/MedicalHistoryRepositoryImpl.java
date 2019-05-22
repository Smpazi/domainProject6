package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.repository.information.MedicalHistoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryMedicalHistory")

public class MedicalHistoryRepositoryImpl implements MedicalHistoryRepository {

    private static MedicalHistoryRepositoryImpl repository = null;

    private Map<String, MedicalHistory> medicalHistoryMap;

    private MedicalHistoryRepositoryImpl(){
        this.medicalHistoryMap = new HashMap<>();
    }
    public static MedicalHistoryRepositoryImpl getRepository(){
        if(repository == null)
            repository = new MedicalHistoryRepositoryImpl();
        return repository;
    }
    @Override
    public Map<String,MedicalHistory> getAll() {
        return medicalHistoryMap;
    }

    @Override
    public MedicalHistory create(MedicalHistory medicalHistory) {
        medicalHistoryMap.put(medicalHistory.getMedHistory_ID(),medicalHistory);
        MedicalHistory savedHistory = medicalHistoryMap.get(medicalHistory.getMedHistory_ID());
        return savedHistory;
    }

    @Override
    public MedicalHistory update(MedicalHistory medicalHistory) {
        medicalHistoryMap.put(medicalHistory.getMedHistory_ID(),medicalHistory);
        MedicalHistory savedHistory = medicalHistoryMap.get(medicalHistory.getMedHistory_ID());
        return savedHistory;
    }

    @Override
    public MedicalHistory read(String s) {
        MedicalHistory medicalHistory = medicalHistoryMap.get(s);
        return medicalHistory;
    }

    @Override
    public void delete(String s) {
        medicalHistoryMap.remove(s);
    }
}
