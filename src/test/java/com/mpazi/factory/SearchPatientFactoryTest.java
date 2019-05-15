package com.mpazi.factory;

import com.mpazi.domain.templete.SearchPatient;
import com.mpazi.factory.other.factory.SearchPatientFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchPatientFactoryTest {

    @Test
    public void getSearchPatientTest(){

        SearchPatient searchPatient = SearchPatientFactory.getSearchPatient("sa233");

        assertEquals("sa233",searchPatient.getSearchId());
    }

}