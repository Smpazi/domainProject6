package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Consultation;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsultationFactoryTest {

    @Test
    public void getConsultationTest(){

        Consultation consultation =ConsultationFactory.getConsultation("");

        assertNotNull(consultation.getConsultId());
    }

}