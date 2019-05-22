package com.mpazi.repository.medication.impl;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.repository.medication.MedicineRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryMedicine")

public class MedicineRepositoryImpl implements MedicineRepository {

    private  static  MedicineRepositoryImpl repository = null;
   private Map<String, Medicine> medicineTable;

    private MedicineRepositoryImpl(){
         this.medicineTable = new HashMap<>();
    }

    public static MedicineRepositoryImpl getRepository(){
        if(repository == null)
            repository = new MedicineRepositoryImpl();
        return repository;
    }

    @Override
    public Medicine create(Medicine medicine) {
        medicineTable.put(medicine.getMed_Id(),medicine);
        Medicine saveMedicine = medicineTable.get(medicine.getMed_Id());
        return saveMedicine;
    }

    @Override
    public Medicine update(Medicine medicine) {
        medicineTable.put(medicine.getMed_Id(),medicine);
        Medicine updateMedicine = medicineTable.get(medicine.getMed_Id());
        return updateMedicine;
    }

    @Override
    public Medicine read(String s) {
        Medicine medicine = medicineTable.get(s);
        return medicine;
    }

    @Override
    public void delete(String s) {
        medicineTable.remove(s);
    }

    @Override
    public Map<String, Medicine> getAll() {
        return medicineTable;
    }
}
