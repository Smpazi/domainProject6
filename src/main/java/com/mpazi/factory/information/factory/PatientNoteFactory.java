package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.util.Misc;

import java.util.Map;

public class PatientNoteFactory {

    public static PatientNote getPatientNote(Map<String, String> values){
        return new PatientNote.Builder()
                .patientNoteId(values.get("PatientNote_Id"))
                .patientNoteType(values.get("PatientNoteType"))
                .build();

    }
}
