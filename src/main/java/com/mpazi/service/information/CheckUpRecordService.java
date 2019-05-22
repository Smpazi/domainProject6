package com.mpazi.service.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.service.IService;

import java.util.Map;

public interface CheckUpRecordService extends IService<CheckUpRecord, String> {
    Map<String, CheckUpRecord> getAll();
}
