package com.mpazi.service.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.service.IService;

import java.util.Set;

public interface MedicalHistoryService extends IService <MedicalHistory, String> {
    Set<MedicalHistory> getAll();
}
