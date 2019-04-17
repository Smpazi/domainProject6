package com.mpazi.factory;

import com.mpazi.domain.TreatmentHistory;

public class TreatmentHistoryFactory {

    public static TreatmentHistory getTreatment(String dosage){
        return new TreatmentHistory.Builder().drugDosage(dosage)
                .build();

    }
}
