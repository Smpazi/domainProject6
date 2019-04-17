package com.mpazi.factory;

import com.mpazi.domain.SearchPatient;
import com.mpazi.util.Misc;

public class SearchPatientFactory {

    public static SearchPatient getSearchPatient(String patientId){
        return new SearchPatient.Builder().searchId(patientId)
                .build();

    }
}
