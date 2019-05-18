package com.mpazi.repository.medication.impl;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.medication.PillRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PillRepositoryImpl implements PillRepository {

    private  static  PillRepositoryImpl repository = null;
  private Map<String, Pill> pillTable;

    private PillRepositoryImpl(){
        this.pillTable = new HashMap<>();
    }

    public static PillRepositoryImpl getRepository(){
        if(repository == null)
            repository = new PillRepositoryImpl();
        return repository;
    }


    @Override
    public Pill create(Pill pill) {
        return null;
    }

    @Override
    public Pill update(Pill pill) {

        return null;
    }

    @Override
    public Pill read(String s) {
        Pill pill = pillTable.get(s);
        return pill;
    }

    @Override
    public void delete(String s) {

        this.pillTable.remove(s);
    }

    @Override
    public Set<Pill> getAll() {
        return null;
    }
}
