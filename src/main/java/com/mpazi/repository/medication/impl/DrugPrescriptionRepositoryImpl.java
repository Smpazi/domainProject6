package com.mpazi.repository.medication.impl;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.repository.medication.DrugPrescriptionRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryDrugPrescription")

public class DrugPrescriptionRepositoryImpl implements DrugPrescriptionRepository {


    private static DrugPrescriptionRepositoryImpl repository =null;

    private Map<String, DrugPrescription> drugPrescriptionTable;

    private DrugPrescriptionRepositoryImpl(){
        drugPrescriptionTable= new HashMap<>();
    }

    public static DrugPrescriptionRepositoryImpl getRepository(){
        if(repository==null)
            repository = new DrugPrescriptionRepositoryImpl();
        return repository;
    }
   @Override
    public Map<String, DrugPrescription> getAll() {
        return drugPrescriptionTable;
    }

    @Override
    public DrugPrescription create(DrugPrescription drugPrescription) {
        drugPrescriptionTable.put(drugPrescription.getDrug_prescriptionId(),drugPrescription);
        DrugPrescription drugPrescription1 = drugPrescriptionTable.get(drugPrescription.getDrug_prescriptionId());
        return drugPrescription1;
    }

    @Override
    public DrugPrescription update(DrugPrescription drugPrescription) {
        drugPrescriptionTable.put(drugPrescription.getDrug_prescriptionId(),drugPrescription);
        DrugPrescription drugPrescription1 =drugPrescriptionTable.get(drugPrescription.getDrug_prescriptionId());
        return drugPrescription1;
    }

    @Override
    public void delete(String id) {
        drugPrescriptionTable.remove(id);
    }

    @Override
    public DrugPrescription read(String id) {
        DrugPrescription drugPrescription = drugPrescriptionTable.get(id);
        return drugPrescription;
    }
}
