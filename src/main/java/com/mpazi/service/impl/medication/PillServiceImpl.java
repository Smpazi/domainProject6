package com.mpazi.service.impl.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.medication.PillRepository;
import com.mpazi.service.medication.PillService;

import java.util.HashMap;
import java.util.Map;

public class PillServiceImpl implements PillService {

    private  static PillServiceImpl repository = null;
  private Map<String, Pill> pillTable;

    private PillServiceImpl(){
        this.pillTable = new HashMap<>();
    }

    public static PillServiceImpl getRepository(){
        if(repository == null)
            repository = new PillServiceImpl();
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
