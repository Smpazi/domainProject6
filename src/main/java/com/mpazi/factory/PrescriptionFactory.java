package com.mpazi.factory;

import com.mpazi.domain.Prescription;

public class PrescriptionFactory {

    public static Prescription getPrescription(String advice){
        return new Prescription.Builder()
                .prescriptionAdvice(advice)
                .build();

    }
}
