package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.Patient;

public class PatientFactory {

    public static Patient getPatient(String patientId,String patientName){
       return new Patient.Builder().patientId(patientId)
               .patientName(patientName)
               .build();
    }
}
