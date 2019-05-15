package com.mpazi.service.other;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.service.IService;

import java.util.Set;

public interface PrescriptionService extends IService<Prescription, String> {
    Set<Prescription> getAll();
}
