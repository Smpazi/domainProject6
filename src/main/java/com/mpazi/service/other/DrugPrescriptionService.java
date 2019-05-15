package com.mpazi.service.other;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.service.IService;

import java.util.Set;

public interface DrugPrescriptionService extends IService<DrugPrescription, String> {
    Set<DrugPrescription> getAll();

}
