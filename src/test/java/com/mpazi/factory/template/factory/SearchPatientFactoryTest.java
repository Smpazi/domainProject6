package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.factory.template.factory.SearchPatientFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchPatientFactoryTest {

    @Test
    public void getSearchPatientTest(){

        SearchPatient searchPatient = SearchPatientFactory.getSearchPatient("sa233");

        assertEquals("sa233",searchPatient.getSearchId());
    }

}