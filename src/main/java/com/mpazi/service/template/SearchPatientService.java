package com.mpazi.service.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.service.IService;

import java.util.Map;
import java.util.Set;

public interface SearchPatientService extends IService<SearchPatient, String> {
   Set<SearchPatient> getAll();
}
