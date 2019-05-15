package com.mpazi.repository.other;

import com.mpazi.domain.templete.SearchPatient;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface SearchPatientRepository extends IRepository<SearchPatient, String> {
    Map<String,SearchPatient> getAll();
}
