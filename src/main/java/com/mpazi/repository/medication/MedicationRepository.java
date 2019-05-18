package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface MedicationRepository extends IRepository<Medication, String> {
    Set<Medication> getAll();
}
