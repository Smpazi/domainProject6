package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Registration;
import com.mpazi.util.Misc;

public class RegistrationFactory {

    public static Registration getRegistration(String user_name){
        return new Registration.Builder().reg_Id(Misc.generateId())
                .staffName(user_name)
                .build();

    }
}
