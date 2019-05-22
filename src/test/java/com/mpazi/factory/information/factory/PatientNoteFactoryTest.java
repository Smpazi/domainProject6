package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.PatientNote;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class PatientNoteFactoryTest {
    Map<String,String> values;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("PatientNote_Id", "333AA");
        values.put("PatientNoteType","patientCheckUps");
    }

    @Test
    public void getPatientNoteTest(){

        PatientNote patientNote =PatientNoteFactory.getPatientNote(values);

        assertEquals("patientCheckUps",patientNote.getPatientNoteType());

        System.out.println(patientNote.getPatientNoteType());

    }

}