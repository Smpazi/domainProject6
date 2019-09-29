package com.mpazi.service.users.impl;

import com.mpazi.domain.users.Nurse;
import com.mpazi.repository.users.NurseRepository;
import com.mpazi.repository.users.impl.NurseRepositoryImpl;
import com.mpazi.service.users.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpNurse")
public class NurseServiceImpl implements NurseService {
    @Qualifier("InMemoryNurse")
    private  static NurseServiceImpl service = null;

    NurseRepository repository = NurseRepositoryImpl.getRepository();

    public static NurseServiceImpl getInstance(){
        if(service == null)
            service =new NurseServiceImpl();
        return service;
    }
    @Override
    public Nurse create(Nurse nurse) {
        return repository.create(nurse);
    }

    @Override
    public Nurse update(Nurse nurse) {
        return repository.update(nurse);
    }

    @Override
    public void delete(String s) {
repository.delete(s);
    }

    @Override
    public Nurse read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Nurse> getAll() {
        return repository.getAll();
    }
}