package com.mpazi.repository.other;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface PrescriptionRepository extends IRepository<Prescription, String> {
    Set<Prescription> getAll();
}
