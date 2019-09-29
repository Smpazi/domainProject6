package com.mpazi.service.users.impl;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.users.ReceptionistRepository;
import com.mpazi.repository.users.impl.ReceptionistRepositoryImpl;
import com.mpazi.service.users.ReceptionistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service  ("ServiceImpReceptionist")
public class ReceptionistServiceImpl implements ReceptionistService {

    @Qualifier("InMemoryReceptionist")
    private  static ReceptionistServiceImpl service = null;

    ReceptionistRepository repository = ReceptionistRepositoryImpl.getRepository();

    public static ReceptionistServiceImpl getInstance(){
        if(service == null)
            service =new ReceptionistServiceImpl();
        return service;
    }
    @Override
    public Receptionist create(Receptionist receptionist) {
        return repository.create(receptionist);
    }

    @Override
    public Receptionist update(Receptionist receptionist) {
        return repository.update(receptionist);
    }

    @Override
    public void delete(String s) {
repository.delete(s);
    }

    @Override
    public Receptionist read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Receptionist> getAll() {
        return repository.getAll();
    }
}
