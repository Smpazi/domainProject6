package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.repository.information.PatientNoteRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PatientNoteRepositoryImpl implements PatientNoteRepository {

    private  static  PatientNoteRepositoryImpl repository = null;
   private Map<String, PatientNote> patientNoteTable;

    private PatientNoteRepositoryImpl(){
        patientNoteTable = new HashMap<>();
    }

    public static PatientNoteRepositoryImpl getRepository(){
        if(repository == null)
            repository = new PatientNoteRepositoryImpl();
        return repository;
    }

    @Override
    public PatientNote create(PatientNote patientNote) {
        patientNoteTable.put(patientNote.getPatientNoteId(),patientNote);
        PatientNote savenNotes = patientNoteTable.get(patientNote.getPatientNoteId());
        return savenNotes;
    }

    @Override
    public PatientNote update(PatientNote patientNote) {
        patientNoteTable.put(patientNote.getPatientNoteId(), patientNote);
        return patientNote;
    }

    @Override
    public PatientNote read(String patientNote_ID) {
        PatientNote patientNote = patientNoteTable.get(patientNote_ID);
        return patientNote;
    }

    @Override
    public void delete(String patientNote_ID) {
        patientNoteTable.remove(patientNote_ID);
    }

    @Override
    public Set<PatientNote> getAll() {
        return null;
    }
}
