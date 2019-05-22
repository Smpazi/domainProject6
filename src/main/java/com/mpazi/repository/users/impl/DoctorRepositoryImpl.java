package com.mpazi.repository.users.impl;

import com.mpazi.domain.users.Doctor;
import com.mpazi.repository.users.DoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryDoctor")

public class DoctorRepositoryImpl implements DoctorRepository {

    private  static  DoctorRepositoryImpl repository = null;
    private Map<String,Doctor> doctorList;

    private DoctorRepositoryImpl(){
        doctorList = new HashMap<>();
    }

    public static DoctorRepositoryImpl getRepository(){
        if(repository == null)
            repository = new DoctorRepositoryImpl();
        return repository;
    }

    @Override
    public Doctor create(Doctor doctor) {
        doctorList.put(doctor.getDoc_practiceNum(),doctor);
        Doctor saveDoctor = doctorList.get(doctor.getDoc_practiceNum());
        return saveDoctor;
    }

    @Override
    public Doctor update(Doctor doctor) {
        doctorList.put(doctor.getDoc_practiceNum(),doctor);
        Doctor updateDoctor = doctorList.get(doctor.getDoc_practiceNum());
        return updateDoctor;
    }

    @Override
    public Doctor read(String doc_Id) {
        Doctor doctor = doctorList.get(doc_Id);
        return doctor;
    }

    @Override
    public void delete(String doc_Id) {
        doctorList.remove(doc_Id);
    }

    @Override
    public Map<String, Doctor> getAll() {
        return doctorList;
    }
}
