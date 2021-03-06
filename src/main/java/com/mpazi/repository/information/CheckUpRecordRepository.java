package com.mpazi.repository.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface CheckUpRecordRepository extends IRepository<CheckUpRecord, String> {
    Map<String, CheckUpRecord> getAll();
}
