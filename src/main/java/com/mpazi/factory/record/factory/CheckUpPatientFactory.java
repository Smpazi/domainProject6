package com.mpazi.factory.record.factory;

import com.mpazi.domain.patient.record.Appointment;
import com.mpazi.domain.patient.record.CheckUpPatient;
import com.mpazi.util.Misc;

public class CheckUpPatientFactory {

    public static CheckUpPatient getCheckUpPatient(String checkUp){
        return new CheckUpPatient.Builder().checkUpId(Misc.generateId())
                .checkUpName(checkUp)
                .build();

    }
}
