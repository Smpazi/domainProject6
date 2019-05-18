package com.mpazi.service.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.service.IService;

import java.util.Set;

public interface CheckUpRecordService extends IService<CheckUpRecord, String> {
    Set<CheckUpRecord> getAll();
}
