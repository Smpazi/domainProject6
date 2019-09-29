package com.mpazi.service.template.impl;

import com.mpazi.domain.template.Treatment;
import com.mpazi.repository.template.TreatmentRepository;
import com.mpazi.repository.template.impl.TreatmentRepositoryImpl;
import com.mpazi.service.template.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpTreatment")
public class TreatmentServiceImpl implements TreatmentService {

    @Qualifier("InMemoryTreatment")
    private  static TreatmentServiceImpl service = null;

    TreatmentRepository repository = TreatmentRepositoryImpl.getRepository();

    public static TreatmentServiceImpl getInstance(){
        if(service == null)
            service =new TreatmentServiceImpl();
        return service;
    }

    @Override
    public Treatment create(Treatment treatment) {
        return repository.create(treatment);
    }

    @Override
    public Treatment update(Treatment treatment) {
        return repository.update(treatment);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Treatment read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Treatment> getAll() {
        return repository.getAll();
    }
}
