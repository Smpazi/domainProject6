package com.mpazi.repository.implementation;

import com.mpazi.domain.DrugPrescription;
import com.mpazi.repository.DrugPrescriptionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DrugPrescriptionRepositoryImpl implements DrugPrescriptionRepository {


    private static DrugPrescriptionRepositoryImpl repository =null;

    private Map<String, DrugPrescription> drugPrescriptionTable;

    private DrugPrescriptionRepositoryImpl(){
        drugPrescriptionTable= new HashMap<String, DrugPrescription>();
    }

    public static DrugPrescriptionRepositoryImpl getInstance(){
        if(repository==null)
            repository = new DrugPrescriptionRepositoryImpl();
        return repository;
    }
   @Override
    public Set<DrugPrescription> getAll() {
        return null;
    }

    @Override
    public DrugPrescription create(DrugPrescription drugPrescription) {
        drugPrescriptionTable.put(String.valueOf(drugPrescription.getDrug_prescriptionId()),drugPrescription);
        DrugPrescription drugPrescription1 =drugPrescriptionTable.get(drugPrescription.getDrugName());
        return drugPrescription1;
    }

    @Override
    public DrugPrescription update(DrugPrescription drugPrescription) {
        drugPrescriptionTable.put(String.valueOf(drugPrescription.getDrug_prescriptionId()),drugPrescription);
        DrugPrescription drugPrescription1 =drugPrescriptionTable.get(drugPrescription.getDrugName());
        return drugPrescription1;
    }

    @Override
    public void delete(String id) {
        drugPrescriptionTable.remove(id);
    }

    @Override
    public DrugPrescription read(String id) {
        DrugPrescription drugPrescription = drugPrescriptionTable.get(id);
        return null;
    }
}
