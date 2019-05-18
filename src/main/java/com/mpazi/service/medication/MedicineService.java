package com.mpazi.service.medication;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.service.IService;

import java.util.Set;

public interface MedicineService extends IService<Medicine, String> {
    Set<Medicine> getAll();
}
