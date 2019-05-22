package com.mpazi.service.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.service.IService;

import java.util.Map;

public interface MedicationService extends IService<Medication, String> {

    Map<String, Medication> getAll();
}
