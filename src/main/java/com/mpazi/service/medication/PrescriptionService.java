package com.mpazi.service.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.service.IService;

import java.util.Map;

public interface PrescriptionService extends IService<Prescription, String> {
    Map<String, Prescription> getAll();
}
