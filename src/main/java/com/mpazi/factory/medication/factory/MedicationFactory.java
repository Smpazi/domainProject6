package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medication;
import com.mpazi.util.Misc;

import java.util.Map;

public class MedicationFactory {

    public static Medication getMedication(Map<String, String> values){
        return new Medication.Builder()
                .med_Id(values.get("Med_ID"))
                .med_description(values.get("Med_Description"))
                .med_Name(values.get("Medication_Name"))
                .build();

    }
}
