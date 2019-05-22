package com.mpazi.service.information;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.service.IService;

import java.util.Map;

public interface CheckUpPatientService extends IService<CheckUpPatient,String> {
    Map<String, CheckUpPatient> getAll();
}
