package com.mpazi.service.medication.impl;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.repository.medication.DrugPrescriptionRepository;
import com.mpazi.repository.medication.impl.DrugPrescriptionRepositoryImpl;
import com.mpazi.service.medication.DrugPrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpDrugPrescription")
public class DrugPrescriptionServiceImpl implements DrugPrescriptionService {

    @Qualifier("InMemoryDrugPrescription")
    private  static DrugPrescriptionServiceImpl service = null;

    DrugPrescriptionRepository repository = DrugPrescriptionRepositoryImpl.getRepository();

    public static DrugPrescriptionServiceImpl getInstance(){
        if(service == null)
            service =new DrugPrescriptionServiceImpl();
        return service;
    }
    @Override
    public Map<String, DrugPrescription> getAll() {
        return repository.getAll();
    }

    @Override
    public DrugPrescription create(DrugPrescription drugPrescription) {
        return repository.create(drugPrescription);
    }

    @Override
    public DrugPrescription update(DrugPrescription drugPrescription) {
        return repository.update(drugPrescription);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public DrugPrescription read(String s) {
        return repository.read(s);
    }
}
