package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.Patient;
import com.mpazi.repository.information.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryPatient")
public  class PatientRepositoryImpl implements PatientRepository {

    private  static  PatientRepositoryImpl repository = null;
    private Map<String, Patient> patientTable;

    private PatientRepositoryImpl(){
        patientTable = new HashMap<>();
    }

    public static PatientRepositoryImpl getRepository(){
        if(repository == null)
            repository = new PatientRepositoryImpl();
        return repository;
    }

    @Override
    public Patient create(Patient patient) {
        patientTable.put(patient.getPatientId(),patient);
        Patient savePatient = patientTable.get(patient.getPatientId());
        return savePatient;
    }

    @Override
    public Patient update(Patient patient) {
        patientTable.put(patient.getPatientId(),patient);
        Patient updatePatient = patientTable.get(patient.getPatientId());
        return updatePatient;
    }

    @Override
    public Patient read(String patient_id) {
        Patient patient = patientTable.get(patient_id);
        return patient;
    }

    @Override
    public void delete(String patient_ID) {
        patientTable.remove(patient_ID);
    }

    @Override
    public Map<String, Patient> getAll() {
        return patientTable;
    }
}
