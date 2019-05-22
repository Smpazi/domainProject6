package com.mpazi.repository.medication.impl;

import com.mpazi.domain.medication.Medication;
import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.information.impl.MedicalHistoryRepositoryImpl;
import com.mpazi.repository.medication.PillRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryPill")
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
        pillTable.put(pill.getPill_ID(),pill);
        Pill savedPill = pillTable.get(pill.getPill_ID());
        return savedPill;
    }

    @Override
    public Pill update(Pill pill) {
        pillTable.put(pill.getPill_ID(),pill);
        Pill savedPill = pillTable.get(pill.getPill_ID());
        return savedPill;
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
    public Map<String, Pill> getAll() {
        return pillTable;
    }
}
