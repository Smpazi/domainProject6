package com.mpazi.factory.record.factory;

import com.mpazi.domain.patient.record.PatientNote;
import com.mpazi.util.Misc;

public class PatientNoteFactory {

    public static PatientNote getPatientNote(String noteType){
        return new PatientNote.Builder().patientNoteId(Misc.generateId())
                .patientNoteType(noteType)
                .build();

    }
}
