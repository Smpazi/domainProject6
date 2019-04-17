package com.mpazi.factory.clinic.medication.factory;

import com.mpazi.domain.clinic.medication.Pill;

public class PillFactory {

    public static Pill getPill(int numQuantity){
        return new Pill.Builder().pillQuantity(numQuantity)
                .build();

    }
}
