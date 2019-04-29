package com.mpazi.repository.implementation.record;

import com.mpazi.domain.patient.record.Patient;
import com.mpazi.repository.record.PatientRepository;

import java.util.HashMap;
import java.util.Map;

public  class PatientRepositoryImpl implements PatientRepository{

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
}
