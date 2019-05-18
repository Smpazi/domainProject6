package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.TransferLetterTemplate;

import java.util.Map;

public class TransferLetterTempleteFactory {

    public static TransferLetterTemplate getTransferLetter(Map<String, String> values){
        return new TransferLetterTemplate.Builder()
                .transfer_ID(values.get("Transfer_Id"))
                .transfer_DoctorName(values.get("Transfer_DoctorName"))
                .build();

    }
}
