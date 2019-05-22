package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.ClinicEmployee;

import java.util.Map;

public class ClinicEmployeeFactory {

    public static ClinicEmployee getClinicEmployee(Map<String, String> value, long emphoneNum){
        return new ClinicEmployee.Builder()
                .emp_Id(value.get("Employee_ID"))
                .empPhoneNum(emphoneNum)
                .build();

    }
}
