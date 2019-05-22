package com.mpazi.repository.users.impl;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.users.ReceptionistRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryReceptionist")

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
        receptionists.put(receptionist.getJob_type(),receptionist);
        Receptionist saveNurse = receptionists.get(receptionist.getJob_type());
        return saveNurse;
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        receptionists.put(receptionist.getJob_type(),receptionist);
        Receptionist saveNurse = receptionists.get(receptionist.getJob_type());
        return saveNurse;
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
    public Map<String, Receptionist> getAll() {
        return receptionists;
    }
}
