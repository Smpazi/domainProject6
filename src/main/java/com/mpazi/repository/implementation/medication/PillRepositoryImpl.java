package com.mpazi.repository.implementation.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.medication.PillRepository;

import java.util.HashMap;
import java.util.Map;

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
        pillTable.put(pill.getMed_Id(), pill);
        Pill savePill = pillTable.get(pill.getMed_Id());
        return savePill;
    }

    @Override
    public Pill update(Pill pill) {
        pillTable.put(pill.getMed_Id(),pill);
        Pill updatePill = pillTable.get(pill.getMed_Id());
        return updatePill;
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
}
