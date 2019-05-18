package com.mpazi.service.information;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.service.IService;

import java.util.Set;

public interface CheckUpPatientService extends IService<CheckUpPatient,String> {
    Set<CheckUpPatient> getAll();
}
