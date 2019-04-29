package com.mpazi.repository;

import com.mpazi.domain.SearchPatient;

import java.util.Map;
import java.util.Set;

public interface SearchPatientRepository extends IRepository<SearchPatient, String> {
    Map<String,SearchPatient> getAll();
}
