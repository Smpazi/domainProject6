package com.mpazi.service.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.service.IService;

import java.util.Map;

public interface SearchPatientService extends IService<SearchPatient, String> {
   Map<String, SearchPatient> getAll();
}
