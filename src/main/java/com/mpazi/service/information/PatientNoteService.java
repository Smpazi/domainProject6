package com.mpazi.service.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.service.IService;

import java.util.Map;

public interface PatientNoteService extends IService<PatientNote, String> {

    Map<String, PatientNote> getAll();
}
