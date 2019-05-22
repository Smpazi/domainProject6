package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.repository.information.CheckUpPatientRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("InMemoryCheckUpPatient")

public class CheckUpPatientRepositoryImpl implements CheckUpPatientRepository {

    private  static  CheckUpPatientRepositoryImpl repository = null;
    private Map<String, CheckUpPatient> checkUpPatients;

    private CheckUpPatientRepositoryImpl(){
        this.checkUpPatients = new HashMap<>();
    }

    public static CheckUpPatientRepository getRepository(){
        if(repository == null)
            repository = new CheckUpPatientRepositoryImpl();
        return repository;
    }

    @Override
    public CheckUpPatient create(CheckUpPatient checkUpPatient) {
        checkUpPatients.put(checkUpPatient.getCheckUp_Id(),checkUpPatient);
        CheckUpPatient savedCheckUp = checkUpPatients.get(checkUpPatient.getCheckUp_Id());
        return savedCheckUp;
    }

    @Override
    public CheckUpPatient update(CheckUpPatient checkUpPatient) {
        checkUpPatients.put(checkUpPatient.getCheckUp_Id(),checkUpPatient);
        CheckUpPatient savedCheckUp = checkUpPatients.get(checkUpPatient.getCheckUp_Id());
        return savedCheckUp;
    }

    @Override
    public CheckUpPatient read(String id) {
        CheckUpPatient checkUpPatient = checkUpPatients.get(id);
        return checkUpPatient;
    }

    @Override
    public void delete(String id) {
        this.checkUpPatients.remove(id);
    }

    @Override
    public Map<String, CheckUpPatient> getAll() {
        return this.checkUpPatients;
    }
}
