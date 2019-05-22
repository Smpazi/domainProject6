package com.mpazi.service.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.service.IService;

import java.util.Map;

public interface MedicalHistoryService extends IService <MedicalHistory, String> {
    Map<String, MedicalHistory> getAll();
}
