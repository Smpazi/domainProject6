package com.mpazi.service.medication.impl;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.medication.PillRepository;
import com.mpazi.repository.medication.impl.PillRepositoryImpl;
import com.mpazi.service.medication.PillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpPill")
public class PillServiceImpl implements PillService {

    @Autowired
    @Qualifier("InMemoryPill")
    private  static PillServiceImpl service = null;

    PillRepository repository = PillRepositoryImpl.getRepository();

    public static PillServiceImpl getInstance(){
        if(service == null)
            service =new PillServiceImpl();
        return service;
    }

    @Override
    public Map<String, Pill> getAll() {
        return repository.getAll();
    }

    @Override
    public Pill create(Pill pill) {
        return repository.create(pill);
    }

    @Override
    public Pill update(Pill pill) {
        return repository.update(pill);
    }

    @Override
    public void delete(String s) {
repository.delete(s);
    }

    @Override
    public Pill read(String s) {
        return repository.read(s);
    }
}
