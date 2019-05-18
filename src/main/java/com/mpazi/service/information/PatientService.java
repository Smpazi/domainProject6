package com.mpazi.service.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.service.IService;

import java.util.Set;

public  interface PatientService extends IService<Patient, String> {

    Set<Patient> getAll();
}
