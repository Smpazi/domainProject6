package com.mpazi.service.information.impl;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.repository.information.MedicalHistoryRepository;
import com.mpazi.repository.information.impl.MedicalHistoryRepositoryImpl;
import com.mpazi.service.information.MedicalHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpMedicalHistory")
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    @Qualifier("InMemoryMedicalHistory")
    private  static MedicalHistoryServiceImpl service = null;

    MedicalHistoryRepository repository = MedicalHistoryRepositoryImpl.getRepository();

    public static MedicalHistoryServiceImpl getInstance(){
        if(service == null)
            service =new MedicalHistoryServiceImpl();
        return service;
    }
    @Override
    public Map<String, MedicalHistory> getAll() {
        return repository.getAll();
    }

    @Override
    public MedicalHistory create(MedicalHistory medicalHistory) {
        return repository.create(medicalHistory);
    }

    @Override
    public MedicalHistory update(MedicalHistory medicalHistory) {
        return repository.update(medicalHistory);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public MedicalHistory read(String s) {
        return repository.read(s);
    }
}
