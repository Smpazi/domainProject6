package com.mpazi.service.template.impl;


import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.repository.template.RecordTempleteRepository;
import com.mpazi.repository.template.impl.RecordTempleteRepositoryImpl;
import com.mpazi.service.template.RecordTempleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpRecordTemplete")
public class RecordTempleteServiceImpl implements RecordTempleteService {

    @Qualifier("InMemoryRecordTemplete")
    private  static RecordTempleteServiceImpl service = null;

    RecordTempleteRepository repository = RecordTempleteRepositoryImpl.getRepository();

    public static RecordTempleteServiceImpl getInstance(){
        if(service == null)
            service =new RecordTempleteServiceImpl();
        return service;
    }

    @Override
    public Map<String, RecordTemplete> getAll() {
        return repository.getAll();
    }

    @Override
    public RecordTemplete create(RecordTemplete recordTemplete) {
        return repository.create(recordTemplete);
    }

    @Override
    public RecordTemplete update(RecordTemplete recordTemplete) {
        return repository.update(recordTemplete);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public RecordTemplete read(String s) {
        return repository.read(s);
    }
}
