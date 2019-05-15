package com.mpazi.service.other;

import com.mpazi.domain.templete.SearchPatient;
import com.mpazi.service.IService;

import java.util.Map;

public interface SearchPatientService extends IService<SearchPatient, String> {
    Map<String,SearchPatient> getAll();
}
