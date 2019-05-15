package com.mpazi.factory.other.factory;

import com.mpazi.domain.medication.DrugPrescription;

import java.util.Map;

public class DrugPrescriptionFactory {

    public  static DrugPrescription getDrugPrescription(Map<String, String> values, String drugUse){
        return new DrugPrescription.Builder()
                .drug_prescriptionId("drug_prescriptionId")
                .drugName(values.get("drugName"))
                .drugType(drugUse)
                .build();
    }
}
