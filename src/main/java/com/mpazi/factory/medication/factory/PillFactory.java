package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Pill;

public class PillFactory {

    public static Pill getPill(int numQuantity){
        return new Pill.Builder()
                .pillQuantity(numQuantity)
                .build();

    }
}
