package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.SearchPatient;

import java.util.Map;

public class SearchPatientFactory {

    public static SearchPatient getSearchPatient(Map<String, String> values){
        return new SearchPatient.Builder()
                .searchId(values.get("SearchId"))
                .patients(values.entrySet())
                .build();

    }
}
