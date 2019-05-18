package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.repository.information.CheckUpRecordRepository;

import java.util.HashSet;
import java.util.Set;

public class CheckUpRecordRepositoryImpl implements CheckUpRecordRepository {

    private  static  CheckUpRecordRepositoryImpl repository = null;
    private Set<CheckUpRecord> checkUpRecords;

    private CheckUpRecordRepositoryImpl(){
        this.checkUpRecords = new HashSet<>();
    }

    public static CheckUpRecordRepositoryImpl getRepository(){
        if(repository == null)
            repository = new CheckUpRecordRepositoryImpl();
        return repository;
    }

    @Override
    public CheckUpRecord create(CheckUpRecord checkUpRecord) {
        this.checkUpRecords.add(checkUpRecord);
        return checkUpRecord;
    }

    @Override
    public CheckUpRecord update(CheckUpRecord checkUpRecord) {
        return null;
    }

    @Override
    public CheckUpRecord read(String s) {
        return null;
    }

    @Override
    public void delete(String chechUp_ID) {
        this.checkUpRecords.remove(chechUp_ID);
    }

    @Override
    public Set<CheckUpRecord> getAll() {
        return null;
    }
}
