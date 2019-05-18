package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.PatientNote;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatientNoteFactoryTest {
    @Test
    public void getPatientNoteTest(){

        PatientNote patientNote =PatientNoteFactory.getPatientNote("patientCheckUps");

        assertEquals("patientCheckUps",patientNote.getPatientNoteType());

        System.out.println(patientNote.getPatientNoteId());

    }

}