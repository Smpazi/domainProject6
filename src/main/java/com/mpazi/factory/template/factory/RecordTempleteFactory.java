package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.RecordTemplete;

import java.util.Map;

public class RecordTempleteFactory {

    public static RecordTemplete getRecordTemplete(Map<String, String> values, int times){
        return new RecordTemplete.Builder()
                .templeteId(values.get("Template_ID"))
                .templateName(values.get("Template_Name"))
                .timeVisit(times)
                .build();

    }
}
