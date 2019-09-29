package com.mpazi.service.information.impl;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.repository.information.CheckUpPatientRepository;
import com.mpazi.repository.information.impl.CheckUpPatientRepositoryImpl;
import com.mpazi.service.information.CheckUpPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service ("ServiceImpCheckUpPatient")
public class CheckUpPatientServiceImpl implements CheckUpPatientService {

    @Qualifier("InMemoryCheckUpPatient")
    private static CheckUpPatientServiceImpl service = null;

    CheckUpPatientRepository repository = CheckUpPatientRepositoryImpl.getRepository();

    public static CheckUpPatientServiceImpl getInstance() {
        if (service == null)
            service = new CheckUpPatientServiceImpl();
        return service;
    }

    @Override
    public CheckUpPatient create(CheckUpPatient checkUpPatient) {
        return repository.create(checkUpPatient);
    }

    @Override
    public CheckUpPatient update(CheckUpPatient checkUpPatient) {
        return repository.update(checkUpPatient);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public CheckUpPatient read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, CheckUpPatient> getAll() {
        return repository.getAll();
    }
}
