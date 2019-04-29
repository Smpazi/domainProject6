package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Medicine;

public class MedicineFactory {

    public static Medicine getMedicine(String createdPlace){
        return new Medicine.Builder().medicine_createdAt(createdPlace)
                .build();
    }
}
