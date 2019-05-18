package com.mpazi.repository.information;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface CheckUpPatientRepository extends IRepository<CheckUpPatient,String> {
    Set<CheckUpPatient> getAll();
}
