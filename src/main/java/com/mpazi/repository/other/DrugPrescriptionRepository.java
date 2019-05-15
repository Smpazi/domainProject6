package com.mpazi.repository.other;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface DrugPrescriptionRepository extends IRepository<DrugPrescription, String> {
    Set<DrugPrescription> getAll();

}
