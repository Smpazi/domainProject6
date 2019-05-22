package com.mpazi.repository.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.repository.IRepository;

import java.util.Map;

public  interface PatientRepository extends IRepository<Patient, String> {
    Map<String, Patient> getAll();
}
