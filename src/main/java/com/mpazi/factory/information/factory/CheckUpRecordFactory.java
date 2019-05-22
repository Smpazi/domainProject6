package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.util.Misc;

import java.util.Map;

public class CheckUpRecordFactory {

    public static CheckUpRecord getCheckUpRecord(Map<String, String> values){
        return new CheckUpRecord.Builder()
                .checkUpRecordId(values.get("CheckUpRecordId"))
                .checkUpRecordName(values.get("CheckUpRecordName"))
                .checkUp_description(values.get("CheckUpDescription"))
                .build();

    }
}
