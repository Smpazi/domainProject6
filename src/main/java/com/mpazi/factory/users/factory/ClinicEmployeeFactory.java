package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;

public class ClinicEmployeeFactory {

    public static ClinicEmployee getClinicEmployee(){
        return new ClinicEmployee.Builder().build();

    }
}
