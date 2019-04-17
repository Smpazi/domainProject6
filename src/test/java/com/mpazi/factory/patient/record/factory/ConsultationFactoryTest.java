package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.Consultation;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsultationFactoryTest {

    @Test
    public void getConsultationTest(){

        Consultation consultation =ConsultationFactory.getConsultation("");

        assertNotNull(consultation.getConsultId());
    }

}