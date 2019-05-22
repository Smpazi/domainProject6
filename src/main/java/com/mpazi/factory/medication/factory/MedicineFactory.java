package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medicine;

import java.util.Map;

public class MedicineFactory {

    public static Medicine getMedicine(Map<String, String> values){
        return new Medicine.Builder()
                .med_ID(values.get("Med_ID"))
                .medicine_createdAt(values.get("Medicine_CreatedAt"))
                .medicine_genricName(values.get("Medicine_GenricName"))
                .build();
    }
}
