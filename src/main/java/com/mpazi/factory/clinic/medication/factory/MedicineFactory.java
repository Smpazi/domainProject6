package com.mpazi.factory.clinic.medication.factory;

import com.mpazi.domain.clinic.medication.Medicine;

public class MedicineFactory {

    public static Medicine getMedicine(String createdPlace){
        return new Medicine.Builder().medicine_createdAt(createdPlace)
                .build();
    }
}
