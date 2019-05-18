package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Doctor;
import com.mpazi.util.Misc;

public class DoctorFactory {

    public static Doctor getDoctor(String docPracticeNum){
        return new Doctor.Builder()
                .doc_practiceNum(docPracticeNum)
                .build();
    }
}
