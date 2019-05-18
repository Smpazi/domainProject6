package com.mpazi.repository.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface SearchPatientRepository extends IRepository<SearchPatient, String> {
    Map<String,SearchPatient> getAll();
}
