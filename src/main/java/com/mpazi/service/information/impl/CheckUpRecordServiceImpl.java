package com.mpazi.service.information.impl;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.repository.information.CheckUpRecordRepository;
import com.mpazi.repository.information.impl.CheckUpRecordRepositoryImpl;
import com.mpazi.service.information.CheckUpRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("ServiceImpCheckUpRecord")
public class CheckUpRecordServiceImpl implements CheckUpRecordService {

    @Autowired
    @Qualifier("InMemoryCheckUpRecord")
    private  static CheckUpRecordServiceImpl service = null;

    CheckUpRecordRepository repository = CheckUpRecordRepositoryImpl.getRepository();

    public static CheckUpRecordServiceImpl getInstance(){
        if(service == null)
            service =new CheckUpRecordServiceImpl();
        return service;
    }

    @Override
    public CheckUpRecord create(CheckUpRecord checkUpRecord) {
        return repository.create(checkUpRecord);
    }

    @Override
    public CheckUpRecord update(CheckUpRecord checkUpRecord) {
        return repository.update(checkUpRecord);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public CheckUpRecord read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, CheckUpRecord> getAll() {
        return repository.getAll();
    }
}
