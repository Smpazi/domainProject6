package com.mpazi.factory.other.factory;

import com.mpazi.domain.templete.RecordTemplete;

public class RecordTempleteFactory {

    public static RecordTemplete getRecordTemplete(String note){
        return new RecordTemplete.Builder().templeteNote(note)
                .build();

    }
}
