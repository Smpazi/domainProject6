package com.mpazi.repository.implementation.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.repository.users.NurseRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        nurses.put(nurse.getEmp_Id(),nurse);
        Nurse saveNurse = nurses.get(nurse.getEmp_Id());
        return saveNurse;
    }

    @Override
    public Nurse update(Nurse nurse) {
        nurses.put(nurse.getEmp_Id(),nurse);
        Nurse updateNurse = nurses.get(nurse.getEmp_Id());
        return updateNurse;
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
}
