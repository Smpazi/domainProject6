package com.mpazi.factory;

import com.mpazi.domain.DrugPrescription;

public class DrugPrescriptionFactory {

    public  static DrugPrescription getDrugPrescription(int prescrId, String drugName){
        return new DrugPrescription.Builder().drug_prescriptionId(prescrId)
                .drugName(drugName)
                .build();
    }
}
