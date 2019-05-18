package com.mpazi.service.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.service.IService;

import java.util.Set;

public interface PatientNoteService extends IService<PatientNote, String> {

    Set<PatientNote> getAll();
}
