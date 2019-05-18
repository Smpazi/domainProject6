package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.MedicalHistory;

import java.util.Map;

public class MedicalHistoryFactory {

    public static MedicalHistory getMedicalHistory(Map<String, String> values){
        return new MedicalHistory.Builder()
                .medHistory_ID(values.get("MedHistory_ID"))
                .allegies(values.get("Patient_Allegies"))
                .cronical_Desease(values.get("Cronical_Desease"))
                .build();
    }
}
