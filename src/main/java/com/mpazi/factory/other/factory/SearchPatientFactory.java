package com.mpazi.factory.other.factory;

import com.mpazi.domain.templete.SearchPatient;

public class SearchPatientFactory {

    public static SearchPatient getSearchPatient(String patientId){
        return new SearchPatient.Builder().searchId(patientId)
                .build();

    }
}
