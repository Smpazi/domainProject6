package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Prescription;

import java.util.Map;

public class PrescriptionFactory {

    public static Prescription getPrescription(Map<String, String> values){
        return new Prescription.Builder()
                .prescriptionId(values.get("Prescription_ID"))
                .visitTime(values.get("VisitTime"))
                .build();

    }
}
