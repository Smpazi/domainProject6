package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.util.Misc;

import java.util.Map;

public class CheckUpPatientFactory {

    public static CheckUpPatient getCheckUpPatient(Map<String, String> values){
        return new CheckUpPatient.Builder()
                .checkUp_Reason(values.get("CheckUp_Reason"))
                .returnDate(values.get("CheckUp_Date"))
                .build();

    }
}
