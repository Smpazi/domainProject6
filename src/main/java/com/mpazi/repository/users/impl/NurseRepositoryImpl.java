package com.mpazi.repository.users.impl;

import com.mpazi.domain.users.Nurse;
import com.mpazi.repository.users.NurseRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NurseRepositoryImpl implements NurseRepository {

    private  static  NurseRepositoryImpl repository = null;
    private Map<String, Nurse> nurses;

    private NurseRepositoryImpl(){
        nurses = new HashMap<>();
    }

    public static NurseRepositoryImpl getRepository(){
        if(repository == null)
            repository = new NurseRepositoryImpl();
        return repository;
    }


    @Override
    public Nurse create(Nurse nurse) {
        return null;
    }

    @Override
    public Nurse update(Nurse nurse) {
        return null;
    }

    @Override
    public Nurse read(String id) {
        Nurse nurse = nurses.get(id);
        return nurse;
    }

    @Override
    public void delete(String id) {
        nurses.remove(id);
    }

    @Override
    public Set<Nurse> getAll() {
        return null;
    }
}
