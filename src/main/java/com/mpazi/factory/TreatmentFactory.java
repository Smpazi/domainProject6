package com.mpazi.factory;

import com.mpazi.domain.Treatment;

import java.util.Map;

public class TreatmentFactory {

    public static Treatment getTreatment(Map<String, String> value, int dosage){
        return new Treatment.Builder()
                .treatment_ID(value.get("treatment_ID"))
                .drugDosage(dosage)
                .build();

    }
}
