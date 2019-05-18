package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Nurse;

public class NurseFactory extends ClinicEmployeeFactory {

    public static Nurse getNurse(String nursing_type){
        return new Nurse.Builder()
                .nursing_Department(nursing_type)
                .build();

    }
}
