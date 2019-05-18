package com.mpazi.repository.medication;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface MedicineRepository extends IRepository<Medicine, String> {

    Set<Medicine> getAll();
}
