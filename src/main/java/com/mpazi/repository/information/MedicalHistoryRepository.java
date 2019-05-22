package com.mpazi.repository.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface MedicalHistoryRepository extends IRepository<MedicalHistory, String > {
    Map<String, MedicalHistory> getAll();

}
