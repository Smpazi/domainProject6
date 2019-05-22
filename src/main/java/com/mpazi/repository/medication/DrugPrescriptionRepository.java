package com.mpazi.repository.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface DrugPrescriptionRepository extends IRepository<DrugPrescription, String> {
    Map<String, DrugPrescription> getAll();

}
