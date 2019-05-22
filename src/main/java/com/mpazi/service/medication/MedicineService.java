package com.mpazi.service.medication;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.service.IService;

import java.util.Map;

public interface MedicineService extends IService<Medicine, String> {
    Map<String, Medicine> getAll();
}
