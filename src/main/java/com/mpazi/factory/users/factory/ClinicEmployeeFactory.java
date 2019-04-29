package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;

public class ClinicEmployeeFactory {

    public static ClinicEmployee getClinicEmployee(String emp_ID, int emphoneNum){
        return new ClinicEmployee.Builder()
                .emp_Id(emp_ID)
                .empPhoneNum(emphoneNum)
                .build();

    }
}
