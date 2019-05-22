package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.factory.template.factory.SearchPatientFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class SearchPatientFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("SearchId","4");

    }
    @Test
    public void getAppointmentTest() {

        SearchPatient searchPatient= SearchPatientFactory.getSearchPatient(values);

        Assert.assertEquals("4",searchPatient.getSearchId());

    }
}