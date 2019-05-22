package com.mpazi.repository.medication.impl;

import com.mpazi.domain.medication.Medication;
import com.mpazi.repository.medication.MedicationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryMedication")

public class MedicationRepositoryImpl implements MedicationRepository {

    private  static  MedicationRepositoryImpl repository = null;
    private Map<String, Medication> medicationTable;

    private MedicationRepositoryImpl(){
        medicationTable = new HashMap<>();
    }

    public static MedicationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new MedicationRepositoryImpl();
        return repository;
    }

    @Override
    public Medication create(Medication medication) {
        medicationTable.put(medication.getMed_Id(),medication);
        Medication createdMedication = medicationTable.get(medication.getMed_Id());
        return createdMedication;
    }

    @Override
    public Medication update(Medication medication) {
        medicationTable.put(medication.getMed_Id(),medication);
        Medication updatedMedcation = medicationTable.get(medication.getMed_Id());
        return updatedMedcation;
    }

    @Override
    public Medication read(String s) {
       Medication medication = medicationTable.get(s);
        return medication;
    }

    @Override
    public void delete(String s) {
        medicationTable.remove(s);
    }

    @Override
    public Map<String, Medication> getAll() {
        return medicationTable;
    }
}
