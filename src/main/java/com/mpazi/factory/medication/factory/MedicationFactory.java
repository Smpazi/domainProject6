package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medication;
import com.mpazi.util.Misc;

public class MedicationFactory {

    public static Medication getMedication(String medName){
        return new Medication.Builder().med_Id(Misc.generateId())
                .med_Name(medName)
                .build();

    }
}
