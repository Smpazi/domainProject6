package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.CheckUpRecord;
import com.mpazi.util.Misc;

public class CheckUpRecordFactory {

    public static CheckUpRecord getCheckUpRecord(String recordName){
        return new CheckUpRecord.Builder().checkUpRecordId(Misc.generateId())
                .checkUpRecordName(recordName)
                .build();

    }
}
