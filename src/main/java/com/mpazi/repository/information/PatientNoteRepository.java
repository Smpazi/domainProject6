package com.mpazi.repository.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface PatientNoteRepository extends IRepository<PatientNote, String> {
    Map<String, PatientNote> getAll();
}
