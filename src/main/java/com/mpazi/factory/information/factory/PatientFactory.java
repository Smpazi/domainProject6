package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Patient;

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
