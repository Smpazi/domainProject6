package com.mpazi.repository.users.impl;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.users.ReceptionistRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReceptionistRepositoryImpl implements ReceptionistRepository {

    private  static  ReceptionistRepositoryImpl repository = null;
    private Map<String, Receptionist> receptionists;

    private ReceptionistRepositoryImpl(){
        receptionists = new HashMap<>();
    }

    public static ReceptionistRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ReceptionistRepositoryImpl();
        return repository;
    }


    @Override
    public Receptionist create(Receptionist receptionist) {
        return null;
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        return null;
    }

    @Override
    public Receptionist read(String id) {
        Receptionist receptionist = receptionists.get(id);
        return receptionist;
    }

    @Override
    public void delete(String id) {
        receptionists.remove(id);
    }

    @Override
    public Set<Receptionist> getAll() {
        return null;
    }
}
