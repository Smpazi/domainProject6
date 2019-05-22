package com.mpazi.factory.medication.factory;

import com.mpazi.domain.medication.Pill;

import java.util.Map;

public class PillFactory {

    public static Pill getPill(Map<String,String> values, int numQuantity){
        return new Pill.Builder()
                .pill_ID(values.get("pill_ID"))
                .pillQuantity(numQuantity)
                .build();

    }
}
