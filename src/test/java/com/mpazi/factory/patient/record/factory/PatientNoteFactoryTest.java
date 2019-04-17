package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.PatientNote;
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