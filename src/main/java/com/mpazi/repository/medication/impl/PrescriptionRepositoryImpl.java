package com.mpazi.repository.medication.impl;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.repository.medication.PrescriptionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryPrescription")

public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    private  static  PrescriptionRepositoryImpl repository = null;
    private Map<String,Prescription> prescriptions;

    private PrescriptionRepositoryImpl(){
        this.prescriptions = new HashMap<>();
    }

    public static PrescriptionRepositoryImpl getRepository(){
        if(repository == null)
            repository = new PrescriptionRepositoryImpl();
        return repository;
    }
    @Override
    public Map<String,Prescription> getAll() {
        return prescriptions;
    }

    @Override
    public Prescription create(Prescription prescription) {
        prescriptions.put(prescription.getPrescriptionId(),prescription);
        Prescription savedPre = prescriptions.get(prescription.getPrescriptionId());
        return savedPre;
    }

    @Override
    public Prescription update(Prescription prescription) {
        prescriptions.put(prescription.getPrescriptionId(),prescription);
        Prescription savedPre = prescriptions.get(prescription.getPrescriptionId());
        return savedPre;
    }

    @Override
    public void delete(String prescriptionsId) {
        prescriptions.remove(prescriptionsId);
    }

    @Override
    public Prescription read(String id) {
        Prescription prescription = prescriptions.get(id);
        return prescription;
    }
}
