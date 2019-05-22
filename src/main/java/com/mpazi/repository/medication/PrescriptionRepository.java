package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.repository.IRepository;

import java.util.Map;
import java.util.Set;

public interface PrescriptionRepository extends IRepository<Prescription, String> {
    Map<String,Prescription> getAll();
}
