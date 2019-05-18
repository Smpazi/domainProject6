package com.mpazi.repository.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface PatientNoteRepository extends IRepository<PatientNote, String> {
    Set<PatientNote> getAll();
}
