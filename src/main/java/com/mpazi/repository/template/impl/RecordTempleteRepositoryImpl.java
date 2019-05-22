package com.mpazi.repository.template.impl;


import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.repository.template.RecordTempleteRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryRecordTemplete")

public class RecordTempleteRepositoryImpl implements RecordTempleteRepository {

    private  static  RecordTempleteRepositoryImpl repository = null;
    private Map<String,RecordTemplete> recordTempletes;

    private RecordTempleteRepositoryImpl(){
        this.recordTempletes= new HashMap<>();
    }

    public static RecordTempleteRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RecordTempleteRepositoryImpl();
        return repository;
    }
    @Override
    public Map<String, RecordTemplete> getAll() {
        return this.recordTempletes;
    }

    @Override
    public RecordTemplete create(RecordTemplete recordTemplete) {
        recordTempletes.put(recordTemplete.getTempleteId(),recordTemplete);
        RecordTemplete savedRecord = recordTempletes.get(recordTemplete.getTempleteId());
        return savedRecord;
    }

    @Override
    public RecordTemplete update(RecordTemplete recordTemplete) {
        recordTempletes.put(recordTemplete.getTempleteId(),recordTemplete);
        RecordTemplete savedRecord = recordTempletes.get(recordTemplete.getTempleteId());
        return savedRecord;
    }

    @Override
    public void delete(String recordTemp_ID) {
        recordTempletes.remove(recordTemp_ID);
    }

    @Override
    public RecordTemplete read(String recordTemp_ID) {
        RecordTemplete templete = recordTempletes.get(recordTemp_ID);
        return templete;
    }
}
