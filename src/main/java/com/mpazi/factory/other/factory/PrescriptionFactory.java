package com.mpazi.factory.other.factory;

import com.mpazi.domain.medication.Prescription;

public class PrescriptionFactory {

    public static Prescription getPrescription(String advice){
        return new Prescription.Builder()
                .prescriptionAdvice(advice)
                .build();

    }
}
