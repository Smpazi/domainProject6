package com.mpazi.factory;

import com.mpazi.domain.TransferLetter;

public class TransferLetterFactory {

    public static TransferLetter getTransferLetter(String transNote){
        return new TransferLetter.Builder().transferNote(transNote)
                .build();

    }
}
