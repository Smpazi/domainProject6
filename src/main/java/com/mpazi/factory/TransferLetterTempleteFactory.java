package com.mpazi.factory;

import com.mpazi.domain.TransferLetterTemplate;

public class TransferLetterTempleteFactory {

    public static TransferLetterTemplate getTransferLetter(String transNote){
        return new TransferLetterTemplate.Builder().transferNote(transNote)
                .build();

    }
}
