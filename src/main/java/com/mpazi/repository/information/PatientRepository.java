package com.mpazi.repository.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.repository.IRepository;

import java.util.Set;

public  interface PatientRepository extends IRepository<Patient, String> {
    Set<Patient> getAll();
}
