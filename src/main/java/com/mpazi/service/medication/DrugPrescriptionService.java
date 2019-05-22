package com.mpazi.service.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.service.IService;

import java.util.Map;

public interface DrugPrescriptionService extends IService<DrugPrescription, String> {
    Map<String, DrugPrescription> getAll();

}
