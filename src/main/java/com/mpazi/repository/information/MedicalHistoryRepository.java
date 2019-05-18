package com.mpazi.repository.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface MedicalHistoryRepository extends IRepository<MedicalHistory, String > {
    Set<MedicalHistory> getAll();

}
