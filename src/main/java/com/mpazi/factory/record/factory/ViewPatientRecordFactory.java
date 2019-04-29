package com.mpazi.factory.record.factory;

import com.mpazi.domain.patient.record.ViewPatientRecord;
import com.mpazi.util.Misc;

public class ViewPatientRecordFactory {

    public static ViewPatientRecord getViewPatientRecord(){
        return new ViewPatientRecord.Builder().recordId(Misc.generateId())
                .build();

    }
}
