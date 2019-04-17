package com.mpazi.factory;

import com.mpazi.domain.RecordTemplete;

public class RecordTempleteFactory {

    public static RecordTemplete getRecordTemplete(String note){
        return new RecordTemplete.Builder().templeteNote(note)
                .build();

    }
}
