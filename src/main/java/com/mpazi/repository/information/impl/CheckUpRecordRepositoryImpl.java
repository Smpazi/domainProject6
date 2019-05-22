package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.repository.information.CheckUpRecordRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryCheckUpRecord")

public class CheckUpRecordRepositoryImpl implements CheckUpRecordRepository {

    private  static  CheckUpRecordRepositoryImpl repository = null;
    private Map<String, CheckUpRecord> checkUpRecords;

    private CheckUpRecordRepositoryImpl(){
        this.checkUpRecords = new HashMap<>();
    }

    public static CheckUpRecordRepositoryImpl getRepository(){
        if(repository == null)
            repository = new CheckUpRecordRepositoryImpl();
        return repository;
    }

    @Override
    public CheckUpRecord create(CheckUpRecord checkUpRecord) {
        checkUpRecords.put(checkUpRecord.getCheckUpRecordId(),checkUpRecord);
        CheckUpRecord savedCheckUpRecord = checkUpRecords.get(checkUpRecord.getCheckUpRecordId());
        return savedCheckUpRecord;
    }

    @Override
    public CheckUpRecord update(CheckUpRecord checkUpRecord) {
        checkUpRecords.put(checkUpRecord.getCheckUpRecordId(),checkUpRecord);
        CheckUpRecord savedCheckUpRecord = checkUpRecords.get(checkUpRecord.getCheckUpRecordId());
        return savedCheckUpRecord;
    }

    @Override
    public CheckUpRecord read(String s) {
        CheckUpRecord checkUpRecord = checkUpRecords.get(s);
        return checkUpRecord;
    }

    @Override
    public void delete(String chechUp_ID) {
        this.checkUpRecords.remove(chechUp_ID);
    }

    @Override
    public Map<String, CheckUpRecord> getAll() {
        return this.checkUpRecords;
    }
}
