package com.mpazi.service.medication.impl;

import com.mpazi.domain.medication.Medication;
import com.mpazi.repository.medication.MedicationRepository;
import com.mpazi.repository.medication.impl.MedicationRepositoryImpl;
import com.mpazi.service.medication.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpMedication")
public class MedicationServiceImpl implements MedicationService {

    @Qualifier("InMemoryMedication")
    private  static MedicationServiceImpl service = null;

    MedicationRepository repository = MedicationRepositoryImpl.getRepository();

    public static MedicationServiceImpl getInstance(){
        if(service == null)
            service =new MedicationServiceImpl();
        return service;
    }
    @Override
    public Medication create(Medication medication) {
        return repository.create(medication);
    }

    @Override
    public Medication update(Medication medication) {
        return repository.update(medication);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Medication read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Medication> getAll() {
        return repository.getAll();
    }
}
