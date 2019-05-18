package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Receptionist;

public class ReceptionistFactory extends ClinicEmployeeFactory {

    public static Receptionist getReceptionist(String job){
        return new Receptionist.Builder().
                job_type(job)
                .build();

    }
}
