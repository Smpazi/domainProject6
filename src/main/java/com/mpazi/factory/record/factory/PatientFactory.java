package com.mpazi.factory.record.factory;

import com.mpazi.domain.patient.record.Patient;

import java.util.Map;

public class PatientFactory {

    public static Patient getPatient(Map<String, String> values, int age){
       return new Patient.Builder()
               .patientId(values.get("patientId"))
               .patientName(values.get("patientName"))
               .age(age)
               .build();
    }
}
