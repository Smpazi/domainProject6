package com.mpazi.service.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.service.IService;

import java.util.Set;

public interface MedicationService extends IService<Medication, String> {

    Set<Medication> getAll();
}
