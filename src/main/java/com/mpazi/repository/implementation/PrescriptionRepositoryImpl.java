package com.mpazi.repository.implementation;

import com.mpazi.domain.Prescription;
import com.mpazi.repository.PrescriptionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrescriptionRepositoryImpl implements PrescriptionRepository {

    int index;
    private  static  PrescriptionRepositoryImpl repository = null;
    private List<Prescription> prescriptions;

    private PrescriptionRepositoryImpl(){
        this.prescriptions = new ArrayList<>();
    }

    public static PrescriptionRepositoryImpl getRepository(){
        if(repository == null)
            repository = new PrescriptionRepositoryImpl();
        return repository;
    }
    @Override
    public Set<Prescription> getAll() {
        return null;
    }

    @Override
    public Prescription create(Prescription prescription) {
        this.prescriptions.add(prescription);
        return prescription;
    }

    @Override
    public Prescription update(Prescription prescription) {
        prescriptions.add(prescription);
        Prescription savedPrescription = prescriptions.get(prescription.getPrescriptionId());
        return savedPrescription;
    }

    @Override
    public void delete(String prescriptionsId) {
        prescriptions.remove(prescriptionsId);
    }

    @Override
    public Prescription read(String id) {
        Prescription prescription = prescriptions.get(index);
        return prescription;
    }
}
