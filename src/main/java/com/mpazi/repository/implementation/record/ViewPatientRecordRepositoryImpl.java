package com.mpazi.repository.implementation.record;

import com.mpazi.domain.patient.record.ViewPatientRecord;
import com.mpazi.repository.record.ViewPatientRecordRepository;

import java.util.HashMap;
import java.util.Map;

public class ViewPatientRecordRepositoryImpl implements ViewPatientRecordRepository {


    private  static  ViewPatientRecordRepositoryImpl repository = null;
   private Map<String, ViewPatientRecord> viewPatientRecordTable;

    private ViewPatientRecordRepositoryImpl(){
        viewPatientRecordTable = new HashMap<>();
    }

    public static ViewPatientRecordRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ViewPatientRecordRepositoryImpl();
        return repository;
    }

    @Override
    public ViewPatientRecord create(ViewPatientRecord viewPatientRecord) {
        viewPatientRecordTable.put(viewPatientRecord.getRecordId(),viewPatientRecord);
        ViewPatientRecord saveViews = viewPatientRecordTable.get(viewPatientRecord.getRecordId());
        return saveViews;
    }

    @Override
    public ViewPatientRecord update(ViewPatientRecord viewPatientRecord) {
        viewPatientRecordTable.put(viewPatientRecord.getRecordId(),viewPatientRecord);
        ViewPatientRecord updatedRecords= viewPatientRecordTable.get(viewPatientRecord.getRecordId());
        return updatedRecords;
    }

    @Override
    public ViewPatientRecord read(String view_ID) {
        ViewPatientRecord viewPatientRecord = viewPatientRecordTable.get(view_ID);
        return viewPatientRecord;
    }

    @Override
    public void delete(String view_ID) {
        viewPatientRecordTable.remove(view_ID);
    }
}
