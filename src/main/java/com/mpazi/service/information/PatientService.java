package com.mpazi.service.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.service.IService;

import java.util.Map;

public  interface PatientService extends IService<Patient, String> {

    Map<String, Patient> getAll();
}
