package com.mpazi.repository.implementation.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.users.ReceptionistRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        receptionists.put(receptionist.getEmp_Id(),receptionist);
        Receptionist saveReception = receptionists.get(receptionist.getEmp_Id());
        return saveReception;
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        receptionists.put(receptionist.getEmp_Id(),receptionist);
        Receptionist updateReception = receptionists.get(receptionist.getEmp_Id());
        return updateReception;
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
}
