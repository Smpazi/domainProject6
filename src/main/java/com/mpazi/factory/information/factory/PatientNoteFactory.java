package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.util.Misc;

public class PatientNoteFactory {

    public static PatientNote getPatientNote(String noteType){
        return new PatientNote.Builder().patientNoteId(Misc.generateId())
                .patientNoteType(noteType)
                .build();

    }
}
