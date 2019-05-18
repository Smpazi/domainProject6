package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Registration;
import com.mpazi.util.Misc;

import java.util.Map;

public class RegistrationFactory {

    public static Registration getRegistration(Map<String, String> values){
        return new Registration.Builder()
                .reg_Id(values.get(Misc.generateId()))
                .staffName(values.get("StaffName"))
                .build();

    }
}
