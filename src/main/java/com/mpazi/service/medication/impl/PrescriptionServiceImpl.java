package com.mpazi.service.medication.impl;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.repository.medication.PrescriptionRepository;
import com.mpazi.repository.medication.impl.PrescriptionRepositoryImpl;
import com.mpazi.service.medication.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpPrescription")
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    @Qualifier("InMemoryPrescription")
    private  static PrescriptionServiceImpl service = null;

    PrescriptionRepository repository = PrescriptionRepositoryImpl.getRepository();

    public static PrescriptionServiceImpl getInstance(){
        if(service == null)
            service =new PrescriptionServiceImpl();
        return service;
    }

    @Override
    public Map<String, Prescription> getAll() {
        return repository.getAll();
    }

    @Override
    public Prescription create(Prescription prescription) {
        return repository.create(prescription);
    }

    @Override
    public Prescription update(Prescription prescription) {
        return repository.update(prescription);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Prescription read(String s) {
        return repository.read(s);
    }
}
