package com.mpazi.repository.implementation;


import com.mpazi.domain.RecordTemplete;
import com.mpazi.repository.RecordTempleteRepository;

import java.util.HashSet;
import java.util.Set;

public class RecordTempleteRepositoryImpl implements RecordTempleteRepository {

    private  static  RecordTempleteRepositoryImpl repository = null;
    private Set<RecordTemplete> recordTempletes;

    private RecordTempleteRepositoryImpl(){
        this.recordTempletes= new HashSet<>();
    }

    public static RecordTempleteRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RecordTempleteRepositoryImpl();
        return repository;
    }
    @Override
    public Set<RecordTemplete> getAll() {
        return this.recordTempletes;
    }

    @Override
    public RecordTemplete create(RecordTemplete recordTemplete) {
        this.recordTempletes.add(recordTemplete);
        return null;
    }

    @Override
    public RecordTemplete update(RecordTemplete recordTemplete) {
        this.recordTempletes.add(recordTemplete);
        return recordTemplete;
    }

    @Override
    public void delete(String recordTemp_ID) {
        recordTempletes.remove(recordTemp_ID);
    }

    @Override
    public RecordTemplete read(String recordTemp_ID) {

        return null;
    }
}
