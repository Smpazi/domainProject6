package com.mpazi.repository.implementation.medication;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.repository.medication.MedicineRepository;

import java.util.HashMap;
import java.util.Map;

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
        medicineTable.put(medicine.getMedicine_genricName(),medicine);
        Medicine saveMedicine = medicineTable.get(medicine.getMedicine_genricName());
        return saveMedicine;
    }

    @Override
    public Medicine update(Medicine medicine) {
        medicineTable.put(medicine.getMedicine_genricName(),medicine);
        Medicine updateMedicine = medicineTable.get(medicine.getMedicine_genricName());
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
}
