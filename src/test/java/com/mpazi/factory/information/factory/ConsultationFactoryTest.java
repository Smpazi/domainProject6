package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Consultation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConsultationFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Consultation_Description","Illness");
        //    values.put("CheckUpDescription","23/April/2011");

    }
    @Test
    public void getConsultationTest() {

        Consultation consultation = ConsultationFactory.getConsultation(values);

        Assert.assertEquals("Illness",consultation.getConsult_description());

    }
}