package com.mpazi.factory.other.factory;

import com.mpazi.domain.templete.TransferLetterTemplate;

public class TransferLetterTempleteFactory {

    public static TransferLetterTemplate getTransferLetter(String transNote){
        return new TransferLetterTemplate.Builder().transferNote(transNote)
                .build();

    }
}
