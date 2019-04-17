package com.mpazi.factory;

import com.mpazi.domain.SearchPatient;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchPatientFactoryTest {

    @Test
    public void getSearchPatientTest(){

        SearchPatient searchPatient = SearchPatientFactory.getSearchPatient("sa233");

        assertEquals("sa233",searchPatient.getSearchId());
    }

}