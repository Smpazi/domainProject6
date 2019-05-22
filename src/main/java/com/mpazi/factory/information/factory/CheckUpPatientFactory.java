package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.factory.users.factory.ClinicEmployeeFactory;
import com.mpazi.util.Misc;

import java.util.Map;

public class CheckUpPatientFactory {

    public static CheckUpPatient getCheckUpPatient(Map<String, String> values){
        return new CheckUpPatient.Builder()
                .checkUp_Id(values.get("CheckUp_ID"))
                .checkUp_Reason(values.get("CheckUp_Reason"))
                .returnDate(values.get("CheckUp_Date"))
                .build();

    }
}
