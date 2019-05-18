package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.repository.information.CheckUpPatientRepository;

import java.util.HashSet;
import java.util.Set;


public class CheckUpPatientRepositoryImpl implements CheckUpPatientRepository {

    private  static  CheckUpPatientRepositoryImpl repository = null;
    private Set<CheckUpPatient> checkUpPatients;

    private CheckUpPatientRepositoryImpl(){
        this.checkUpPatients = new HashSet<>();
    }

    public static CheckUpPatientRepository getRepository(){
        if(repository == null)
            repository = new CheckUpPatientRepositoryImpl();
        return repository;
    }

    @Override
    public CheckUpPatient create(CheckUpPatient checkUpPatient) {
        this.checkUpPatients.add(checkUpPatient);
        return checkUpPatient;
    }

    @Override
    public CheckUpPatient update(CheckUpPatient checkUpPatient) {
        return null;
    }

    @Override
    public CheckUpPatient read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {
        this.checkUpPatients.remove(s);
    }
}
